package impl;

import entity.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SwitcherHandler extends HandlerImpl {
    public SwitcherHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected void dataHandling(Message message) {
        // 发送报文
        Thread sender = new Thread(new SenderImpl(message));
        sender.start();
    }

    @Override
    public void run() {

    }
}
