package entity;

import java.net.Socket;
import java.util.ArrayList;

public class Translator {
    public ArrayList<Entry> table = new ArrayList<>();
    int portNum = 0;

    public Entry searchRequest(String src_ip, int protocol, Socket socket) {
        Entry entry = table.stream().filter(e -> e.src_ip.equals(src_ip)).filter(e -> e.protocol== protocol).findFirst().orElse(null);

        if (entry == null) {
            entry = new Entry(protocol, src_ip, Client.port, NAT.E1_IP, 12000 + portNum, System.currentTimeMillis(), socket);
            portNum++;
            addEntry(entry);
        }

        return entry;
    }

    public Entry searchAnswer(String dst_ip, int protocol) {
        return table.stream().filter(e -> e.dst_ip.equals(dst_ip)).filter(e -> e.protocol == protocol).findFirst().orElse(null);
    }

    public void addEntry(Entry entry) {
        table.add(entry);
    }

    public void delEntry(Entry entry) {
        table.remove(entry);
    }
}
