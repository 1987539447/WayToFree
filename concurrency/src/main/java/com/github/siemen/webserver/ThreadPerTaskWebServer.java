package com.github.siemen.webserver;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 为每个请求分配一个线程处理
 * 无法控制线程增长
 * 线程声明周期开销
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();

        }
    }

    private static void handleRequest(Socket connection) {
        System.out.println("----handling request----");
    }
}
