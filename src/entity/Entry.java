package entity;

public record Entry(int protocol, String src_ip, int src_port, String dst_ip, int dst_port, long liveTime) {
}
