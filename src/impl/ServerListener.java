package impl;

import java.net.Socket;

public class ServerListener extends ListenerImpl {
    protected void startHandling(Socket clientSocket) {
        Thread handler = new Thread(new ServerHandler(clientSocket));
        handler.start();
    }

    @Override
    public void run() {
        super.run();
    }
}
