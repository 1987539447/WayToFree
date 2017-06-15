package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 通过Executor处理请求
 * 通过定长线程池限制数量，提交runable执行
 */
public class TaskExecutorWebServer {

    private static final int MAX_THREAD = 10;
    private static final Executor exec =Executors.newFixedThreadPool(MAX_THREAD);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        while (true){
            final Socket connection = socket.accept();
            Runnable task = () -> Client.handleRequest(connection);
            exec.execute(task);
        }
    }
}
