package impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DataHandler implements Runnable {
    private final Socket clientSocket;

    public DataHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            // Get Client Input
            inputStream = clientSocket.getInputStream();
            System.out.println(inputStream.toString());

            // Set Server Output
            outputStream = clientSocket.getOutputStream();
            outputStream.write("GOT IT".getBytes());
            outputStream.flush();

            // Close IOStreams
            inputStream.close();
            outputStream.close();

            // Close Socket
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
