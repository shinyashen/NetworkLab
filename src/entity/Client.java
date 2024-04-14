package entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        byte[] in_buf = new byte[1024];
        byte[] out_buf = new byte[1024];
        try {
            String server_ip = "200.5.3.1";
            Socket clientSocket = new Socket(server_ip, 8888);
            outputStream = clientSocket.getOutputStream();
            outputStream.write(out_buf);
            outputStream.flush();
            inputStream = clientSocket.getInputStream();
            int read_len = inputStream.read(in_buf);
            inputStream.close();
            outputStream.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
