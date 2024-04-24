package impl;

import entity.NAT;

public class Scanner implements Runnable {
    @Override
    public void run() {
        while(true) {
            if (!NAT.table.table.isEmpty()) {
                NAT.table.table.stream().filter(e -> e.liveTime() - System.currentTimeMillis() >= 2 * 60 * 1000).forEach(e -> NAT.table.delEntry(e));
            }
        }
    }
}