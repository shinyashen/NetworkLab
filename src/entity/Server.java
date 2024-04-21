package entity;

import UI.ServerFrame;
import impl.ListenerImpl;

public class Server extends ServerFrame {
    public static void main(String[] args) {
        // Set Server UI
        setServerFrame();

        // Create Listening Thread
        Thread listening = new Thread(new Server());
        listening.start();
    }
}



