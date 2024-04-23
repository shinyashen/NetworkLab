package entity;

import UI.SwitcherFrame;
import impl.SwitcherListener;

public class Switcher extends SwitcherFrame {
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new SwitcherListener(7456));
        listener.start();
        System.out.println("Switcher listening on port 7456");
    }
}
