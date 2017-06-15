package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 每任务一线程实现
 * 线程开销，资源消耗，程序不稳定
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        while (true){
            final Socket connection = socket.accept();
            Runnable task = () -> Client.handleRequest(connection);
            new Thread(task).start();
        }
    }
}
