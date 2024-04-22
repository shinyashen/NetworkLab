package impl;

import java.net.Socket;

public class SwitcherListener extends ListenerImpl {
    protected void startHandling(Socket clientSocket) {
        Thread handler = new Thread(new SwitcherHandler(clientSocket));
        handler.start();
    }

    @Override
    public void run() {
        super.run();
    }
}
