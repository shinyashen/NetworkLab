package impl;

import entity.Message;

import java.net.Socket;

public class SwitcherHandler extends HandlerImpl {
    public SwitcherHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected void dataHandling(Message message) {
        // 发送报文
        Thread sender = new Thread(new SenderImpl(message));
        sender.start();

        System.out.println("Switcher Send: " + new String(message.getData()));
    }

    @Override
    public void run() {
        super.run();
    }
}
