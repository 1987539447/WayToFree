package com.github.siemen.webserver;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 使用线程池的webserver
 * 通过Executors创建固定大小连接池
 * 通过execute提交任务
 */
public class TaskExecutionWebServer {

    private static final int N_THREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(N_THREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            exec.execute(task);

        }
    }

    private static void handleRequest(Socket connection) {
        System.out.println("----handling request----");
    }
}
