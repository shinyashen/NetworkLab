package impl;

import entity.Entry;
import entity.Message;
import entity.NAT;

import java.net.Socket;

public class NATHandler extends HandlerImpl {

    public NATHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected Message dataHandling(Message message) {
        // 处理请求分组报文
        Entry entry = NAT.table.searchRequest(message.getSrcIp(), message.getProtocol());
        message.setSrcIP(entry.dst_ip());
        message.setSrcPort(entry.dst_port());

        // 发送报文
        System.out.println("NAT发送：" + new String(message.getData()));
        Message recMessage = Sender.send(message, 7453);

        // 处理应答分组报文
        entry = NAT.table.searchAnswer(recMessage.getDstIp(), recMessage.getProtocol());
        recMessage.setDstIP(entry.dst_ip());
        recMessage.setDstPort(entry.dst_port());

        System.out.println("NAT收到：" + new String(recMessage.getData()));
        return recMessage;
    }

    @Override
    public void run() {
        super.run();
    }
}
