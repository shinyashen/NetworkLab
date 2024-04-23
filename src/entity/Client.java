package entity;

import UI.ClientFrame;
import impl.SenderImpl;

public class Client extends ClientFrame {
    private static final String client_ip = "localhost";
    private static final int client_port = 8888;

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 发送数据
        sendData();
    }

    public static String getIp() {
        return client_ip;
    }

    public static int getPort() {
        return client_port;
    }

    private static void sendData() {
        // 构造报文
        int type = 0;
        int protocol = 0;
        String destIP = "localhost";
        int destPort = 7456;
        String testMessage = "Hello World!";
        byte[] data=testMessage.getBytes();
        Message message = new Message(type, protocol,destIP, getIp(), destPort, getPort(), data.length, data);

        // 发送报文
        Thread sender = new Thread(new SenderImpl(message));
        sender.start();
    }
}