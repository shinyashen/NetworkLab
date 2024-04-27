package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

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

    // 在各自窗口的信息框内输出信息
    public abstract void appendInfo(String info);

    // 初始化窗口内容
    public abstract void initComponents();

    // 窗口退出
    public abstract void frameExit(ActionEvent e);
}
