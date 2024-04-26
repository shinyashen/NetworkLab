package impl;

import entity.NAT;
import ui.NATFrame;

import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

public class Scanner implements Runnable {
    public static final NATFrame frame = NAT.frame;
    public static long liveMilliSeconds = 10 * 1000;

    @Override
    public void run() {
        while (true) {
            try {
                if (!NAT.translator.table.isEmpty())
                    NAT.translator.table.removeAll(NAT.translator.table.stream().filter(Objects::nonNull).filter(e -> System.currentTimeMillis() - e.liveTime >= liveMilliSeconds).
                            collect(Collectors.toCollection(Vector::new)));
                frame.updateTable();
                //System.out.println(NAT.translator.table.size());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}