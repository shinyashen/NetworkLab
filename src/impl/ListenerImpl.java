package impl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenerImpl implements Runnable {
    @Override
    public void run() {
        String clientAddress;

        try(ServerSocket serverSocket = new ServerSocket(25565)) {
            System.out.println("Server listening on port " + serverSocket.getLocalPort());

            while(true) try {
                Socket clientSocket = serverSocket.accept();
                clientAddress = clientSocket.getRemoteSocketAddress().toString();
                System.out.println("Receiving request from: " + clientAddress);

                // 创建线程
                Thread handler = new Thread(new HandlerImpl(clientSocket));
                handler.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
