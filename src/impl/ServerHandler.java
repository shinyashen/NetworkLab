package impl;

import entity.Message;
import java.net.Socket;

public class ServerHandler extends HandlerImpl {
    public ServerHandler(Socket clientSocket) {
        super(clientSocket);
    }

    protected void dataHandling(Message message) {
        System.out.println("Server Send: "+new String(message.getData()));
    }

    @Override
    public void run() {
        super.run();
    }
}
