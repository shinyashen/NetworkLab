package entity;

import UI.ServerFrame;
import impl.ServerListener;

public class Server extends ServerFrame {
    public static final String IP = "200.5.3.1";
    public static final int fakePort = 80;
    public static final int realPort = 7453;

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listening = new Thread(new ServerListener(realPort));
        listening.start();
        System.out.println("服务器监听端口为：" + fakePort);
    }
}



