package entity;

import java.net.Socket;

public class Entry {
    public int protocol;
    public String src_ip;
    public int src_port;
    public String dst_ip;
    public int dst_port;
    public long liveTime;
    public Socket socket;

    public Entry(int protocol, String src_ip, int src_port, String dst_ip, int dst_port, long liveTime, Socket socket) {
        this.protocol = protocol;
        this.src_ip = src_ip;
        this.src_port = src_port;
        this.dst_ip = dst_ip;
        this.dst_port = dst_port;
        this.liveTime = liveTime;
        this.socket = socket;
    }

    public String fromWhere() {
        return switch (src_ip) {
            case "10.0.0.1" -> "A";
            case "10.0.0.2" -> "B";
            case "10.0.0.3" -> "C";
            default -> "";
        };
    }
}
