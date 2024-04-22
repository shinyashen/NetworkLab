package impl;

import entity.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SenderImpl implements Runnable {
    Message message;
    public SenderImpl(Message message) {this.message = message;}

    @Override
    public void run() {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;

        try (Socket clientSocket = new Socket(message.getDestIP(), message.getDestPort())) {
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(message);
            outputStream.flush();

            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            Object object=inputStream.readObject();
            Message destMessage = (Message) object;
            System.out.println("Client Received: "+new String(destMessage.getData()));

            inputStream.close();
            outputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
