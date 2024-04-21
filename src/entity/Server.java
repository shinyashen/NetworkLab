package entity;

import UI.ServerFrame;
import impl.DataHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerFrame implements Runnable {
    public static void main(String[] args) {
        // Set Server UI
        setServerFrame();

        // Create Listening Thread
        Thread listening = new Thread(new Server());
        listening.start();
    }

    public void run() {
        socketListener();
    }

    private static void socketListener() {
        String clientAddress;

        try(ServerSocket serverSocket = new ServerSocket(25565)) {
            System.out.println("Server listening on port 80");

            while(true) try {
                Socket clientSocket = serverSocket.accept();
                clientAddress = clientSocket.getRemoteSocketAddress().toString();
                System.out.println("Receiving request from: " + clientAddress);

                // Create Thread
                Thread handler = new Thread(new DataHandler(clientSocket));
                handler.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}



