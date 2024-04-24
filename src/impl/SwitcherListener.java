package impl;

import java.net.Socket;

public class SwitcherListener extends ListenerImpl {
    public SwitcherListener(int port) {
        super(port);
    }

    protected void startHandling(Socket clientSocket) {
        String clientAddress = clientSocket.getRemoteSocketAddress().toString().substring(1);
        System.out.println("交换机从" + clientAddress + "接收到了报文");

        Thread handler = new Thread(new SwitcherHandler(clientSocket));
        handler.start();
    }

    @Override
    public void run() {
        super.run();
    }
}
