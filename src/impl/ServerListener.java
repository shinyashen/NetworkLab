package impl;

import entity.Server;
import ui.ServerFrame;

import java.net.Socket;

public class ServerListener extends ListenerImpl {
    public static final ServerFrame frame = Server.frame;
    public ServerListener(int port) {
        super(port);
    }

    protected void startHandling(Socket clientSocket) {
        String clientAddress = clientSocket.getRemoteSocketAddress().toString().substring(1);
        frame.appendInfo("服务器从" + clientAddress + "接收到了报文");
        System.out.println("服务器从" + clientAddress + "接收到了报文");

        Thread handler = new Thread(new ServerHandler(clientSocket));
        handler.start();
    }

    @Override
    public void run() {
        super.run();
    }
}
