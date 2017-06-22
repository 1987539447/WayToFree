package com.github.siemen.webserver;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程webserver
 * 只能顺序化处理请求
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        System.out.println("----handling request----");
    }
}
