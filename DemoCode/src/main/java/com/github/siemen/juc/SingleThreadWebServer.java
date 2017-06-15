package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 单线程顺序执行webserver
 * 顺序执行，效率低下
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        while (true){
            Socket connection = socket.accept();
            Client.handleRequest(connection);
        }
    }

}
