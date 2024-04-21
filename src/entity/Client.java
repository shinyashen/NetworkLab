package entity;

import UI.ClientFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client extends ClientFrame {
    private static final String srcIP = "localhost";
    private static final int srcPort = 25564;
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
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;
        int type=0;
        int protocol=0;
        String destIP="localhost";
        int destPort=25565;
        String testMessage="Hello World";
        byte[] data=testMessage.getBytes();
        Message srcMessage = new Message(type, protocol,destIP, getSrcIP(), destPort, getSrcPort(), data.length, data);

        try (Socket clientSocket = new Socket(destIP, destPort)) {
            outputStream = (ObjectOutputStream) clientSocket.getOutputStream();
            outputStream.writeObject(srcMessage);
            outputStream.flush();

            inputStream = (ObjectInputStream) clientSocket.getInputStream();
            Object object=inputStream.readObject();
            Message destMessage = (Message) object;
            System.out.println(Arrays.toString(destMessage.getData()));

            inputStream.close();
            outputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}