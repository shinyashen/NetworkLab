package entity;

import impl.ServerListener;
import ui.ServerFrame;

public class Server {
    public static final ServerFrame frame = new ServerFrame();
    public static final String IP = frame.getIP();
    public static int fakePort = frame.getPort();
    public static final int realPort = 7453;

    public static void main(String[] args) {
        // 显示窗口
        frame.showWindow(700, 500);
    }

    public static void startListening() {
        // 创建监听线程
        Thread listening = new Thread(new ServerListener(realPort));
        listening.start();
        System.out.println("服务器监听端口为：" + fakePort);
    }
}



