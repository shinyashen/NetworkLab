package entity;

import UI.SwitcherFrame;
import impl.ListenerImpl;

public class Switcher extends SwitcherFrame {
    public static void main(String[] args) {
        // Create UI
        setFrame();

        // 创建
        Thread listener = new Thread(new ListenerImpl());
        listener.start();
    }
}
