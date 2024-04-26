package impl;

import entity.NAT;
import ui.NATFrame;

import java.util.Objects;

public class Scanner implements Runnable {
    public static final NATFrame frame = NAT.frame;
    public static int liveSeconds = 10;

    @Override
    public void run() {

        while (true) {
            try {
                if (!NAT.table.table.isEmpty())
                    NAT.table.table.stream().filter(e -> System.currentTimeMillis() - Objects.requireNonNull(e.liveTime) >= liveSeconds * 1000).forEach(e -> NAT.table.delEntry(e));
                frame.updateTable();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}