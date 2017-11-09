package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import static com.javarush.task.task30.task3008.ConsoleHelper.*;


/**
 * Created by v.usov on 08.11.2017.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){

        for (Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            }catch (IOException e) {
                writeMessage("Error sending message for user " + pair.getKey());
            }
        }

    }

    public static void main(String[] args) {

        writeMessage("Enter port for server.");
        //int port = readInt();

        try(ServerSocket serverSocket = new ServerSocket(readInt())){

            writeMessage("Server started.");
            while (true) {
//                Socket tempSocket = null;
//                if((tempSocket=serverSocket.accept()) != null){
//                    new Handler(tempSocket).start();
//                    writeMessage("New client(" + tempSocket.getRemoteSocketAddress() + ") try to connect.");
//                }
                new Handler(serverSocket.accept()).start();
            }

        } catch (Exception e){
            writeMessage("Error on the serverSocket.");
        }


    }

    private static class Handler extends Thread{

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {


            if(socket != null && socket.getRemoteSocketAddress() != null)
            writeMessage("Connection with client (" + socket.getRemoteSocketAddress() + ") established.");
            String userName = null;

            try(Connection connection = new Connection(socket)) {

                writeMessage("Connection with client (" + connection.getRemoteSocketAddress() + ") established.");

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                writeMessage("Error(Handler_run) on methods serverHandshake or serverMainLoop or new_Connection or sendListOfUsers.");
            }  finally {
                if(userName !=  null && connectionMap.containsKey(userName)) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                writeMessage("Connection with user closed."); //"+ userName + "
            }


        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true){
                Message tempMess = connection.receive();
                if(tempMess != null && tempMess.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + tempMess.getData()));
                }else writeMessage("Error!");

            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            for (Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
                if(!pair.getKey().equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true){

                connection.send(new Message(MessageType.NAME_REQUEST));
                Message getName = connection.receive();

                if (getName.getType() == MessageType.USER_NAME) {
                    if (!getName.getData().isEmpty()) {
                        if (!connectionMap.containsKey(getName.getData())) {
                            connectionMap.put(getName.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            writeMessage("User " + getName.getData() + " connected to the server.");
                            return getName.getData();
                        }
                    }
                }

            }


        }
    }


}
