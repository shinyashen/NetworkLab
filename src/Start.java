import entity.Client;
import entity.NAT;
import entity.Server;
import entity.Switcher;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class Start {
    public static void main(String[] args) {
        initGlobalFontSetting(new Font("微软雅黑", Font.PLAIN, 12)); // 全局窗口字体样式

        Client.main(args); // 运行客户端窗口
        Switcher.main(args); // 运行交换机窗口
        NAT.main(args); // 运行NAT窗口
        Server.main(args); // 运行服务器窗口
    }

    public static void initGlobalFontSetting(Font fnt) {
        // 设置全局窗口字体样式
        FontUIResource fontRes = new FontUIResource(fnt);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }
}
