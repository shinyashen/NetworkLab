package entity;

import UI.NATFrame;
import impl.NATListener;
import impl.Scanner;

public class NAT extends NATFrame {
    public static Translator table = new Translator(); // 转换表

    public static void main(String[] args) {
        // 设置UI
        setFrame();

        // 创建监听线程
        Thread listener = new Thread(new NATListener(7452));
        listener.start();
        System.out.println("NAT监听端口为：7452");

        // 启用转换表扫描线程
        Thread scanner = new Thread(new Scanner());
        scanner.start();
    }
}
