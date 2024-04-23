package impl;

import java.net.Socket;

public class ServerListener extends ListenerImpl {
    public ServerListener(int port) {
        super(port);
    }

    protected void startHandling(Socket clientSocket) {
        String clientAddress = clientSocket.getRemoteSocketAddress().toString().substring(1);
        System.out.println("Server Receiving Message from: " + clientAddress);

        Thread handler = new Thread(new ServerHandler(clientSocket));
        handler.start();
    }

    @Override
    public void run() {
        super.run();
    }
}
