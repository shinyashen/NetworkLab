package entity;

import UI.ServerFrame;
import impl.ListenerImpl;

public class Server extends ServerFrame {
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listening = new Thread(new ListenerImpl());
        listening.start();
    }
}



