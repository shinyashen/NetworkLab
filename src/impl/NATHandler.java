package impl;

import entity.Message;

import java.net.Socket;

public class NATHandler extends HandlerImpl {
    public NATHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected void dataHandling(Message message) {
        // 发送报文
        Thread sender = new Thread(new SenderImpl(message));
        sender.start();

        System.out.println("NAT Send: " + new String(message.getData()));
    }

    @Override
    public void run() {
        super.run();
    }
}
