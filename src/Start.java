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
        // 全局设置窗口字体
        initGlobalFontSetting(new Font("微软雅黑", Font.PLAIN, 12));

        // 客户端窗口
        Client.main(args);

        // 交换机窗口
        Switcher.main(args);

        // NAT窗口
        NAT.main(args);

        // 服务器窗口
        Server.main(args);
    }

    public static void initGlobalFontSetting(Font fnt) {
        FontUIResource fontRes = new FontUIResource(fnt);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }
}
