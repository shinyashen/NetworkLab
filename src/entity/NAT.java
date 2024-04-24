package entity;

import UI.NATFrame;
import impl.NATListener;

public class NAT extends NATFrame {
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new NATListener(7452));
        listener.start();
        System.out.println("NAT listening on port 7452");
    }
}
