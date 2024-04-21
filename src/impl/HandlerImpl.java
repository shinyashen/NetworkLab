package impl;

import entity.Message;

import java.io.*;
import java.net.Socket;

public class HandlerImpl implements Runnable {
    private final Socket clientSocket;

    public HandlerImpl(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    protected static void dataHandling(Message message) {
        // 什么也不做
    }

    @Override
    public void run() {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;

        try {
            // 获取客户端输入
            inputStream =  new ObjectInputStream(clientSocket.getInputStream());
            Object object = inputStream.readObject();
            Message inputMessage = (Message)object;

            // 数据处理
            dataHandling(inputMessage);

            // 设置服务端输出
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(inputMessage);

            // 关闭IO流
            inputStream.close();
            outputStream.close();

            // 关闭Socket
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
