package impl;

import entity.Entry;
import entity.Message;
import entity.NAT;
import entity.Server;
import ui.NATFrame;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NATHandler extends HandlerImpl {
    public static final NATFrame frame = NAT.frame;

    public NATHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected Message dataHandling(Message message) {

        if (message.getType() == 0) {
            // 处理请求分组报文
            Entry entry = NAT.translator.searchRequest(message.getSrcIp(), message.getProtocol(), clientSocket);
            message.setSrcIP(entry.dst_ip);
            message.setSrcPort(entry.dst_port);

            // 发送报文
            frame.appendInfo("NAT收到：" + entry.fromWhere() + "的请求分组，源地址为" + entry.src_ip + "，端口号为" + entry.src_port + "，协议为" + ((entry.protocol == 0) ? "TCP" : "UDP"));
            frame.appendInfo("NAT发送：" + new String(message.getData()));
            System.out.println("NAT发送：" + new String(message.getData()));
            Sender.send(message, Server.realPort);
        } else {
            // 处理应答分组报文
            Entry entry = NAT.translator.searchAnswer(message.getDstIp(), message.getDstPort(), message.getProtocol());
            message.setDstIP(entry.dst_ip);
            message.setDstPort(entry.dst_port);

            frame.appendInfo("NAT收到：服务器进程向" + entry.fromWhere() + "发送的应答分组");
            frame.appendInfo("NAT收到并发送：" + new String(message.getData()));
            System.out.println("NAT收到：" + new String(message.getData()));
            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(entry.socket.getOutputStream());
                outputStream.writeObject(message);
                outputStream.close();

                entry.socket = null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @Override
    public void run() {
        super.run();
    }
}