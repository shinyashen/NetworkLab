package impl;

import entity.Message;

import java.net.Socket;
import java.util.Arrays;

public class ServerHandler extends HandlerImpl implements Runnable {
    public ServerHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected static void dataHandling(Message message) {
        System.out.println(new String(message.getData()));
    }

    @Override
    public void run() {
        super.run();
    }
}
