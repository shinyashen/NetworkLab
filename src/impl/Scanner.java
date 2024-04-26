package impl;

import entity.NAT;
import ui.NATFrame;

public class Scanner implements Runnable {
    public static final NATFrame frame = NAT.frame;

    @Override
    public void run() {
        while (true) {
            try {
                if (!NAT.table.table.isEmpty())
                    NAT.table.table.stream().filter(e -> System.currentTimeMillis() - e.liveTime >= 2 * 60 * 1000).forEach(e -> NAT.table.delEntry(e));
                frame.updateTable();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}