package impl;

import entity.Message;
import entity.NAT;

import java.net.Socket;

public class SwitcherHandler extends HandlerImpl {
    public SwitcherHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected Message dataHandling(Message message) {
        // 向NAT发送报文
        System.out.println("交换机发送：" + new String(message.getData()));

        // 将收到的报文发送回主机
        Message recMessage = Sender.send(message, NAT.port);
        System.out.println("交换机收到：" + new String(recMessage.getData()));
        return recMessage;
    }

    @Override
    public void run() {
        super.run();
    }
}
