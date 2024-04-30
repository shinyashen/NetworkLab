package impl;

import java.net.Socket;

public class NATListener extends ListenerImpl {
    public NATListener(int port) {
        super(port);
    }

    protected void startHandling(Socket clientSocket) {
        String clientAddress = clientSocket.getRemoteSocketAddress().toString().substring(1);
        System.out.println("NAT从" + clientAddress + "接收到了报文");

        Thread handler = new Thread(new NATHandler(clientSocket));
        handler.start();
    }

    @Override
    public void run() {
        super.run();
    }
}