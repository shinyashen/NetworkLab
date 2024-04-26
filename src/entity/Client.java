package entity;

import impl.Sender;
import ui.ClientFrame;

import java.util.Objects;

public class Client {
    public static final ClientFrame frame = new ClientFrame();
    public static int port = frame.getPort();

    public static void main(String[] args) {
        // 显示窗口
        frame.showWindow(100, 100);
    }

    public static void sendData(String src_ip) {
        // 构造报文
        int protocol = frame.getProtocol();
        String dest_ip = Server.IP;
        int dest_port = Server.fakePort;
        port = frame.getPort();
        String testMessage = Objects.requireNonNull(frame.getData());
        byte[] data = testMessage.getBytes();
        Message message = new Message(0, protocol, dest_ip, src_ip, dest_port, port, data.length, data);

        // 向最近的网关发送报文
        frame.appendInfo(message.fromWhere() + "向服务器请求报文：" + testMessage);
        Message recMessage = Sender.send(message, Switcher.port);
        frame.appendInfo(message.fromWhere() + "收到服务器应答报文：" + new String(recMessage.getData()));
        System.out.println("客户端收到：" + new String(recMessage.getData()));
    }
}