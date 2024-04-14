//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//public class Client {
//    public static void main(String[] args) {
//        InputStream inputStream;
//        OutputStream outputStream;
//        byte[] in_buf = new byte[1024];
//        byte[] out_buf = new byte[1024];
//        try {
//            String server_ip = "200.5.3.1";
//            Socket clientSocket = new Socket(server_ip, 8888);
//            outputStream = clientSocket.getOutputStream();
//            outputStream.write(out_buf);
//            outputStream.flush();
//            inputStream = clientSocket.getInputStream();
//            int read_len = inputStream.read(in_buf);
//            inputStream.close();
//            outputStream.close();
//            clientSocket.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
package entity;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    public static boolean socket_status=false;
    public static void main(String[] args) {
        connect();
    }

    private static void connect() {
        try {
            socket = new Socket("127.0.0.1",8888);
            socket_status = true;
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream =new ObjectInputStream(socket.getInputStream());
            new Thread(new Client_listen(socket,objectInputStream));
            new Thread(new Client_send(socket,objectOutputStream));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Client_listen implements Runnable{
    private Socket socket;
    private ObjectInputStream objectInputStream;
    Client_listen(Socket socket,ObjectInputStream objectInputStream){
        this.socket=socket;
        this.objectInputStream=objectInputStream;
    }

    @Override
    public void run(){
        try {
            System.out.println(objectInputStream.readObject());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Client_send implements Runnable{

    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    Client_send(Socket socket,ObjectOutputStream objectOutputStream) {
        this.socket=socket;
        this.objectOutputStream=objectOutputStream;
    }

    @Override
    public void run(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请客户端输入：");
                String string = scanner.nextLine();

                objectOutputStream.writeObject(string);
                objectOutputStream.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}