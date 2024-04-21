package UI;

import javax.swing.*;

public class Frame {
    protected static JFrame frame;

    // Set Basic Frame
    protected static void setFrame() {
        frame.setLocation(300, 300);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
