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

        // 服务器
        Server.main(args);

        // NAT
        NAT.main(args);

        // 交换机
        Switcher.main(args);

        // 客户端
        Client.main(args);
    }

    public static void initGlobalFontSetting(Font fnt){
        FontUIResource fontRes = new FontUIResource(fnt);
        for(Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }
}
