package UI;

import javax.swing.*;

public class Frame {
    public static void createJFrame(String title) {
        JFrame frame = new JFrame();
        frame.setLocation(300, 300);
        frame.setSize(400, 300);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
