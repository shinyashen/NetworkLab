package entity;

import UI.SwitcherFrame;
import impl.SwitcherHandler;
import impl.SwitcherListener;

public class Switcher extends SwitcherFrame {
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new SwitcherListener());
        listener.start();
    }
}
