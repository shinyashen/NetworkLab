package entity;

import java.net.Socket;

public class Entry {
    public int protocol; // 协议
    public String src_ip; // 源IP地址
    public int src_port; // 源端口号
    public String dst_ip; // 目的IP地址
    public int dst_port; // 目的端口号
    public long liveTime; // 生成时间
    public Socket socket; // 所携带的socket

    public Entry(int protocol, String src_ip, int src_port, String dst_ip, int dst_port, long liveTime, Socket socket) {
        this.protocol = protocol;
        this.src_ip = src_ip;
        this.src_port = src_port;
        this.dst_ip = dst_ip;
        this.dst_port = dst_port;
        this.liveTime = liveTime;
        this.socket = socket;
    }

    public String fromWhere() { // 匹配客户端编号
        return switch (src_ip) {
            case "10.0.0.1" -> "A";
            case "10.0.0.2" -> "B";
            case "10.0.0.3" -> "C";
            default -> "";
        };
    }
}
