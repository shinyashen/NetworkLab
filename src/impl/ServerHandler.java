package impl;

import entity.Message;
import entity.NAT;
import entity.Server;
import ui.ServerFrame;

import java.net.Socket;

public class ServerHandler extends HandlerImpl {
    public static final ServerFrame frame = Server.frame;

    public ServerHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected Message dataHandling(Message message) {
        Message serverMessage = new Message(1, message.getProtocol(), message.getSrcIp(), message.getDstIp(), message.getSrcPort(), message.getDstPort(), message.getLen(), ("收到：" + new String(message.getData())).getBytes());

        // 返回应答分组报文
        frame.appendInfo("服务器收到：" + NAT.translator.fromWhere(message.getSrcIp(), message.getSrcPort(), message.getProtocol()) + "发送的请求分组");
        frame.appendInfo("服务器发送：" + new String(serverMessage.getData()));
        System.out.println("服务器发送：" + new String(serverMessage.getData()));
        Sender.send(serverMessage, NAT.port);

        return null;
    }

    @Override
    public void run() {
        super.run();
    }
}