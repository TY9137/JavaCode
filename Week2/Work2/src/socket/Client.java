package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {//ctrl+Alt+T
            Socket server=new Socket("127.0.0.1",7777);
            OutputStream os = server.getOutputStream();
            PrintStream ps =new PrintStream(os);
            ps.println("hello");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
