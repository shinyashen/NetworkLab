package entity;

import UI.ClientFrame;
import impl.Sender;

public class Client extends ClientFrame {

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 发送数据
        sendData("10.0.0.1");
    }

    private static void sendData(String src_ip) {
        // 构造报文
        int type = 0;
        int protocol = 0;
        String dest_ip = "200.5.3.1";
        int dest_port = 80;
        String testMessage = "你好服务器！";
        byte[] data = testMessage.getBytes();
        Message message = new Message(type, protocol, dest_ip, src_ip, dest_port, 8888, data.length, data);

        // 向最近的网关发送报文
        Message recMessage = Sender.send(message, 7451);
        System.out.println("客户端收到：" + new String(recMessage.getData()));
    }
}