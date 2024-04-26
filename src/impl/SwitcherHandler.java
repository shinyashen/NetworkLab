package impl;

import entity.Message;
import entity.NAT;
import entity.Switcher;
import ui.SwitcherFrame;

import java.net.Socket;

public class SwitcherHandler extends HandlerImpl {
    public static final SwitcherFrame frame = Switcher.frame;

    public SwitcherHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected Message dataHandling(Message message) {
        // 向NAT发送报文
        frame.appendInfo("交换机收到：" + message.fromWhere() + "向服务器发送的请求分组");
        frame.appendInfo("交换机发送：" + new String(message.getData()));
        System.out.println("交换机发送：" + new String(message.getData()));

        // 将收到的报文发送回主机
        Message recMessage = Sender.send(message, NAT.port);
        frame.appendInfo("交换机收到：服务器进程向" + message.fromWhere() + "发送的应答分组");
        frame.appendInfo("交换机收到并发送：" + new String(recMessage.getData()));
        System.out.println("交换机收到：" + new String(recMessage.getData()));
        return recMessage;
    }

    @Override
    public void run() {
        super.run();
    }
}
