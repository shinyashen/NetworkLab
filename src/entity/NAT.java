package entity;

import UI.NATFrame;
import impl.NATListener;
import impl.Scanner;

public class NAT extends NATFrame {
    public static Translator table = new Translator(); // 转换表
    public static final String E0_IP = "10.0.0.100";
    public static final String E1_IP = "128.10.10.1";
    public static final int port = 7452;

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new NATListener(port));
        listener.start();
        System.out.println("NAT监听端口为：" + port);

        // 启用转换表扫描线程
        Thread scanner = new Thread(new Scanner());
        scanner.start();
    }
}
