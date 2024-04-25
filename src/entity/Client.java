package entity;

import UI.ClientFrame;
import impl.Sender;

public class Client extends ClientFrame {
    public static final String[] clientIP = {"10.0.0.1", "10.0.0.2", "10.0.0.3"};
    public static final int port = 8888;

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 发送数据
        sendData(clientIP[0]);
    }

    private static void sendData(String src_ip) {
        // 构造报文
        int protocol = 0;
        String dest_ip = Server.IP;
        int dest_port = Server.fakePort;
        String testMessage = "你好服务器！";
        byte[] data = testMessage.getBytes();
        Message message = new Message(0, protocol, dest_ip, src_ip, dest_port, port, data.length, data);

        // 向最近的网关发送报文
        Message recMessage = Sender.send(message, Switcher.port);
        System.out.println("客户端收到：" + new String(recMessage.getData()));
    }
}