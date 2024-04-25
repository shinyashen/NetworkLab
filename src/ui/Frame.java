package ui;

import javax.swing.*;

public class Frame {
    protected static JFrame frame;

    // 设置共同初始窗口
    protected static void setFrame() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
