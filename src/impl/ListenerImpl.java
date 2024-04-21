package impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenerImpl implements Runnable {
    protected static void startHandling(Socket clientSocket) {

    }

    @Override
    public void run() {
        String clientAddress;

        try(ServerSocket serverSocket = new ServerSocket(7456)) {
            System.out.println("Server listening on port " + serverSocket.getLocalPort());
            serverSocket.setReuseAddress(true);

            while(true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientAddress = clientSocket.getRemoteSocketAddress().toString();
                    System.out.println("Receiving request from: " + clientAddress);

                    // 创建线程
                    startHandling(clientSocket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
