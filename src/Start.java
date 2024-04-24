import entity.Client;
import entity.NAT;
import entity.Server;
import entity.Switcher;

public class Start {
    public static void main(String[] args) {

        // 服务器
        Server.main(args);

        // NAT
        NAT.main(args);

        // 交换机
        Switcher.main(args);

        // 客户端
        Client.main(args);


    }
}
