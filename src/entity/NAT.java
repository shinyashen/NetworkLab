package entity;

import impl.NATListener;
import impl.Scanner;
import ui.NATFrame;

public class NAT {
    public static Translator translator = new Translator(); // 转换表
    public static final int port = 7452;
    public static final NATFrame frame = new NATFrame();
    public static final String E0_IP = "10.0.0.100";
    public static final String E1_IP = frame.getIP();

    public static void main(String[] args) {
        // 显示窗口
        frame.showWindow(100, 500);
    }

    public static void startListening() {
        // 创建监听线程
        Thread listener = new Thread(new NATListener(port));
        listener.start();
        System.out.println("NAT监听端口为：" + port);

        // 启用转换表扫描线程
        Thread scanner = new Thread(new Scanner());
        scanner.start();
    }
}
