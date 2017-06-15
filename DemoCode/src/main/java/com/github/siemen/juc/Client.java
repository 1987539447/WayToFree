package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.io.*;
import java.net.Socket;

/**
 * Socket连接测试
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        writer.write("hello");
        writer.flush();
        writer.close();
    }

    public static void handleRequest(Socket connection) {
        BufferedReader reader = null;
        String text;
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            text = "error";
        }
        System.out.println("----------------read from socket----------");
        System.out.println(text);
        System.out.println("-------------------------------------------");
    }
}
