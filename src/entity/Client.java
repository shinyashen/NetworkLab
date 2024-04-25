package entity;

import ui.ClientFrame;
import impl.Sender;

public class Client {
    public static final String[] clientIP = {"10.0.0.1", "10.0.0.2", "10.0.0.3"};
    public static final int port = 8888;
    public static final ClientFrame frame = new ClientFrame();

    public static void main(String[] args) {
        // 设置窗口
        frame.ClientWindowShow();
    }

    public static void sendData(String src_ip) {
        // 构造报文
        int protocol = 0;
        String dest_ip = Server.IP;
        int dest_port = Server.fakePort;
        String testMessage = "你好服务器！";
        byte[] data = testMessage.getBytes();
        Message message = new Message(0, protocol, dest_ip, src_ip, dest_port, port, data.length, data);
        //System.out.println(message.getSrcIp());

        // 向最近的网关发送报文
        Message recMessage = Sender.send(message, Switcher.port);
        System.out.println("客户端收到：" + new String(recMessage.getData()));
    }
}