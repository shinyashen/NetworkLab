package entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        byte[] in_buf = new byte[1024];
        byte[] out_buf = new byte[1024];
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket clientSocket = serverSocket.accept();
            inputStream = clientSocket.getInputStream();
            int read_len = inputStream.read(in_buf);
            outputStream = clientSocket.getOutputStream();
            outputStream.write(out_buf);
            outputStream.flush();
            inputStream.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
