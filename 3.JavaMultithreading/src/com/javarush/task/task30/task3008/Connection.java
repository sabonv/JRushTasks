package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by v.usov on 08.11.2017.
 */
public class Connection implements Closeable {

    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException{
        this.socket = socket;

        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());

    }


    public void send(Message message) throws IOException{
        synchronized (out){
            out.writeObject(message);
            out.flush();
        }

    }

    public Message receive() throws IOException, ClassNotFoundException {

        synchronized (in) {
            Object obj = in.readObject();
            if (obj != null && obj instanceof Message) return (Message) obj;
            else return null;
        }
        //return (Message) in.readObject();
    }

    public SocketAddress getRemoteSocketAddress() {

        return socket.getRemoteSocketAddress();
    }


    @Override
    public void close() throws IOException {

        out.close();
        in.close();
        socket.close();

    }
}
