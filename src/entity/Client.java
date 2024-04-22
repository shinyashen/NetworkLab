package entity;

import UI.ClientFrame;
import impl.SenderImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client extends ClientFrame {
    private static final String srcIP = "localhost";
    private static final int srcPort = 7456;
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 发送数据
        sendData();
    }

    public static String getSrcIP() {
        return srcIP;
    }

    public static int getSrcPort() {
        return srcPort;
    }

    private static void sendData() {
        // 构造报文
        int type=0;
        int protocol=0;
        String destIP="localhost";
        int destPort=7456;
        String testMessage = "Hello World!";
        byte[] data=testMessage.getBytes();
        Message message = new Message(type, protocol,destIP, getSrcIP(), destPort, getSrcPort(), data.length, data);

        // 发送报文
        Thread sender = new Thread(new SenderImpl(message));
        sender.start();
    }
}