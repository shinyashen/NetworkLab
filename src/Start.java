import entity.Client;
import entity.Server;

public class Start {
    public static void main(String[] args) {
        // Clients
        String[] client_1_args = {"Client 1"};
        String[] client_2_args = {"Client 2"};
        String[] client_3_args = {"Client 3"};

        Client.main(client_1_args);
        Client.main(client_2_args);
        Client.main(client_3_args);

        // Servers
        String[] server_args = {"Server"};
        Server.main(server_args);

        // Switcher
        // TODO();

        // NAT
        // TODO();
    }
}
