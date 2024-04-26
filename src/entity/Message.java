package entity;

import java.io.Serializable;

public class Message implements Serializable {
    private final int type; // 报文类型
    private final int protocol; // 协议
    private String dst_ip; // 目的IP地址
    private String src_ip; // 源IP地址
    private int dst_port; // 目的端口号
    private int src_port; // 源端口号
    private final int len; // 数据长度
    private final byte[] data; // 数据

    public Message(int type, int protocol, String dst_ip, String src_ip, int dst_port, int src_port, int len, byte[] data) {
        this.type = type;
        this.protocol = protocol;
        this.dst_ip = dst_ip;
        this.src_ip = src_ip;
        this.dst_port = dst_port;
        this.src_port = src_port;
        this.len = len;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public int getDstPort() {
        return dst_port;
    }

    public String getDstIp() {
        return dst_ip;
    }

    public String getSrcIp() {
        return src_ip;
    }

    public int getProtocol() {
        return protocol;
    }

    public int getLen() {
        return len;
    }

    public void setSrcIP(String src_ip) {
        this.src_ip = src_ip;
    }

    public void setSrcPort(int src_port) {
        this.src_port = src_port;
    }

    public int getSrcPort() {
        return src_port;
    }

    public void setDstIP(String dst_ip) {
        this.dst_ip = dst_ip;
    }

    public void setDstPort(int dst_port) {
        this.dst_port = dst_port;
    }

    public int getType() {
        return type;
    }

    public String fromWhere() {
        if (src_ip.equals("10.0.0.1")) {
            return "A";
        } else if (src_ip.equals("10.0.0.2")) {
            return "B";
        } else if (src_ip.equals("10.0.0.3")) {
            return "C";
        } else
            return "";
    }
}