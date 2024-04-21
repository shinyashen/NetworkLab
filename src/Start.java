import entity.Client;
import entity.Server;
import entity.Switcher;

public class Start {
    public static void main(String[] args) {
        // Servers
        Server.main(args);

        // Clients
        Client.main(args);

        // Switcher
        //Switcher.main(args);

        // NAT
        // TODO();
    }
}
