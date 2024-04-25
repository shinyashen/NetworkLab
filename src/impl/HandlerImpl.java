package impl;

import entity.Message;

import java.io.*;
import java.net.Socket;

public abstract class HandlerImpl implements Runnable {
    protected final Socket clientSocket;

    public HandlerImpl(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    protected abstract Message dataHandling(Message message);

    @Override
    public void run() {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;

        try {
            // 获取发送方报文
            inputStream =  new ObjectInputStream(clientSocket.getInputStream());
            Object object = inputStream.readObject();
            Message inputMessage = (Message)object;

            // 数据处理
            Message outputMessage = dataHandling(inputMessage);

            // 向发送方返回报文
            if (!clientSocket.isClosed()) {
                outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                outputStream.writeObject(outputMessage);
                outputStream.close();
            }

            // 关闭IO流
            inputStream.close();

            // 关闭Socket
            clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
