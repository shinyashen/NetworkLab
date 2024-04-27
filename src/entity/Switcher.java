package entity;

import impl.SwitcherListener;
import ui.SwitcherFrame;

public class Switcher {
    public static final int port = 7451;
    public static final SwitcherFrame frame = new SwitcherFrame();

    public static void main(String[] args) {
        // 显示窗口
        frame.showWindow(700, 100);
    }
    
    public static void startListening() {
        // 创建监听线程
        Thread listener = new Thread(new SwitcherListener(port));
        listener.start();
        System.out.println("交换机监听端口为：" + port);
    }
}
