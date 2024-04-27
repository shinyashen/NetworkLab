package entity;

import java.net.Socket;
import java.util.Arrays;
import java.util.Vector;

public class Translator {
    public Vector<Entry> table = new Vector<>();
    public static Boolean[] occupiedPortList = new Boolean[53536];

    public Translator() {
        Arrays.fill(occupiedPortList, false);
    }

    public Entry searchRequest(String src_ip, int protocol, Socket socket) {
        Entry entry = table.stream().filter(e -> e.src_ip.equals(src_ip)).filter(e -> e.src_port == Client.port).filter(e -> e.protocol == protocol).findFirst().orElse(null);

        if (entry == null) {
            for (int i = 0; i < occupiedPortList.length; i++) {
                if (!occupiedPortList[i]) {
                    entry = new Entry(protocol, src_ip, Client.port, NAT.E1_IP, 12000 + i, System.currentTimeMillis(), socket);
                    table.add(entry);
                    occupiedPortList[i] = true;
                    break;
                }
            }
        } else {
            entry.liveTime = System.currentTimeMillis();
            entry.socket = socket;
        }

        return entry;
    }

    public Entry searchAnswer(String dst_ip, int dst_port, int protocol) {
        return table.stream().filter(e -> e.dst_ip.equals(dst_ip)).filter(e -> e.dst_port == dst_port).filter(e -> e.protocol == protocol).findFirst().orElse(null);
    }

    public String fromWhere(String ip, int port, int protocol) {
        Entry entry = table.stream().filter(e -> e.dst_ip.equals(ip)).filter(e -> e.dst_port == port).filter(e -> e.protocol == protocol).findFirst().orElse(null);

        if (entry != null) {
            return switch (entry.src_ip) {
                case "10.0.0.1" -> "A";
                case "10.0.0.2" -> "B";
                case "10.0.0.3" -> "C";
                default -> "";
            };
        } else {
            return "";
        }
    }
}
