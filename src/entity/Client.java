package entity;

import UI.ClientFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends ClientFrame {
    public static void main(String[] args) {
        // Set Client UI
        setClientFrame();

        // Client Send Data
        sendData();
    }

    private static void sendData() {
        InputStream inputStream;
        OutputStream outputStream;

        try (Socket clientSocket = new Socket("localhost", 25565)) {
            outputStream = clientSocket.getOutputStream();
            outputStream.write("Hello World".getBytes());
            outputStream.flush();

            inputStream = clientSocket.getInputStream();
            System.out.println(inputStream.toString());

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}