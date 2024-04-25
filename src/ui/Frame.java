package ui;

import javax.swing.*;

public abstract class Frame extends JFrame {
    public Frame() {
        initComponents();
    }

    // 设置并显示窗口
    public void showWindow(int width, int height) {
        SwingUtilities.invokeLater(() -> {
            setLocation(width, height);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        });
    }

    public abstract void appendInfo(String info);

    public abstract void initComponents();
}
