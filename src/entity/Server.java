//package entity;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//    public static void main(String[] args) {
//        InputStream inputStream;
//        OutputStream outputStream;
//        byte[] in_buf = new byte[1024];
//        byte[] out_buf = new byte[1024];
//        try {
//            ServerSocket serverSocket = new ServerSocket(8888);
//            Socket clientSocket = serverSocket.accept();
//            inputStream = clientSocket.getInputStream();
//            int read_len = inputStream.read(in_buf);
//            outputStream = clientSocket.getOutputStream();
//            outputStream.write(out_buf);
//            outputStream.flush();
//            inputStream.close();
//            clientSocket.close();
//            serverSocket.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
package entity;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        System.out.println("服务端已启动！");
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            while (true) {
                // 接受socket请求
                Socket socket = serverSocket.accept();
                new Thread(new Server_listen(socket)).start();
                new Thread(new Server_send(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Server_listen implements Runnable {
    private Socket socket;

    Server_listen(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println(objectInputStream.readObject());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Server_send implements Runnable{

    private Socket socket;

    Server_send(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请服务端输入：");
                String string = scanner.nextLine();

                objectOutputStream.writeObject(string);
                objectOutputStream.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}