package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

import static com.javarush.task.task30.task3008.ConsoleHelper.*;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try{
            synchronized (this){
                this.wait();
            }
        }catch (InterruptedException e) {
            writeMessage("Error of client on first init.");
            System.exit(1);
        }

        if(clientConnected) writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected){
            String tempText = readString();
            if(tempText != null ) {
                if( !tempText.equals("exit")){
                    if(shouldSendTextFromConsole())
                    sendTextMessage(tempText);
                }
                else break;
            }

        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            writeMessage("User " + userName + " now is with us.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            writeMessage("User " + userName + " left us.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {

            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }

        }


    }

    protected String getServerAddress() {
        writeMessage("Enter address of server:");
        return readString();
    }

    protected int getServerPort() {
        writeMessage("Enter port of server:");
        return readInt();
    }

    protected String getUserName() {
        writeMessage("Enter your nic name:");
        return readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {

        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            writeMessage("");
            clientConnected = false;
        }
    }

}
