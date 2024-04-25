package impl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class ListenerImpl implements Runnable {
    private final int port;

    public ListenerImpl(int port) {
        this.port = port;
    }

    protected abstract void startHandling(Socket clientSocket);

    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);

            while(true) {
                try {
                    Socket clientSocket = serverSocket.accept();

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
