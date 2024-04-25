package entity;

import ui.SwitcherFrame;
import impl.SwitcherListener;

public class Switcher extends SwitcherFrame {
    public static final int port = 7451;

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new SwitcherListener(port));
        listener.start();
        System.out.println("交换机监听端口为：" + port);
    }
}
