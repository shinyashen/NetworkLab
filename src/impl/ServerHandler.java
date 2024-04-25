package impl;

import entity.Message;
import entity.NAT;

import java.net.Socket;

public class ServerHandler extends HandlerImpl {
    public ServerHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected Message dataHandling(Message message) {
        Message serverMessage = new Message(1, message.getProtocol(), message.getSrcIp(), message.getDstIp(), message.getSrcPort(), message.getDstPort(), message.getLen(), ("收到：" + new String(message.getData())).getBytes());
        System.out.println("服务器发送：" + new String(serverMessage.getData()));
        Sender.send(serverMessage, NAT.port);

        return null;
    }

    @Override
    public void run() {
        super.run();
    }
}
