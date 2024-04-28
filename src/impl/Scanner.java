package impl;

import entity.Entry;
import entity.NAT;
import entity.Translator;
import ui.NATFrame;

import java.util.Collection;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

public class Scanner implements Runnable {
    public static final NATFrame frame = NAT.frame;
    public static final long liveMilliSeconds = 120 * 1000;

    @Override
    public void run() {
        while (true) {
            try {
                if (!NAT.translator.table.isEmpty()) {
                    Collection<Entry> removeItems = NAT.translator.table.stream().filter(Objects::nonNull).filter(e -> System.currentTimeMillis() - e.liveTime >= liveMilliSeconds).collect(Collectors.toCollection(Vector::new));
                    if (!removeItems.isEmpty()) {
                        for (Entry e : removeItems) {
                            Translator.occupiedPortList[e.dst_port - 12000] = false;
                        }
                        NAT.translator.table.removeAll(removeItems);
                    }
                    frame.updateTable();
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}