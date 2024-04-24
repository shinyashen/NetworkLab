package entity;

import UI.SwitcherFrame;
import impl.SwitcherListener;

public class Switcher extends SwitcherFrame {
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new SwitcherListener(7451));
        listener.start();
        System.out.println("交换机监听端口为：7451");
    }
}
