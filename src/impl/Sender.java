package impl;

import entity.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
    public static Message send(Message message, int port) {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;

        try (Socket clientSocket = new Socket("localhost", port)) {
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(message);
            outputStream.flush();

            // 接受应答分组
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            Object object = inputStream.readObject();
            Message destMessage = (Message) object;

            inputStream.close();
            outputStream.close();
            return destMessage;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}