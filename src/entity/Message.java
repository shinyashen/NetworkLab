package entity;

public class Message {
    private final int type; // 报文类型
    private final int protocol; // 协议
    private final String destIP; // 目的IP地址
    private final String srcIP; // 源IP地址
    private int destPort; // 目的端口号
    private int srcPort; // 源端口号
    private final int len; // 数据长度
    private final byte[] data; // 数据

    public Message(int type, int protocol, String destIp, String srcIp, int destPort, int srcPort, int len, byte[] data) {
        this.type = type;
        this.protocol = protocol;
        this.destIP = destIp;
        this.srcIP = srcIp;
        this.destPort = destPort;
        this.srcPort = srcPort;
        this.len = len;
        this.data = data;
    }

    // get方法
    public int getType() {
        return type;
    }

    public int getProtocol() {
        return protocol;
    }

    public String getDestIP() {
        return destIP;
    }

    public String getSrcIp() {
        return srcIP;
    }

    public int getDestPort() {
        return destPort;
    }

    public int getSrcPort() {
        return srcPort;
    }

    public int getLen() {
        return len;
    }

    public byte[] getData() {
        return data;
    }

    // set方法
    public void setDestPort(int destPort) {
        this.destPort = destPort;
    }

    public void setSrcPort(int srcPort) {
        this.srcPort = srcPort;
    }
}