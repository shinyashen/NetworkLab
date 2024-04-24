package entity;

import UI.ServerFrame;
import impl.ServerListener;

public class Server extends ServerFrame {
    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listening = new Thread(new ServerListener(7453));
        listening.start();
        System.out.println("Server listening on port 7453");
    }
}



