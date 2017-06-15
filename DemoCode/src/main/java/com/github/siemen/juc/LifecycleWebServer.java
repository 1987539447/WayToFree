package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;


/**
 * 具有生命周期的webserver,异常关闭和控制关闭
 * 通过ExecutorService 执行shutdown
 */
public class LifecycleWebServer {
    private static final int MAX_THREAD = 10;
    private static final ExecutorService exec =Executors.newFixedThreadPool(MAX_THREAD);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        while (true){
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            try{
                exec.execute(task);
            }catch (RejectedExecutionException e){
                if(!exec.isShutdown()){
                    System.out.println("---task submission is rejected---");
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleRequest(Socket connection) {
        String text = readRequst(connection);
        if("stop".equalsIgnoreCase(text)){
            stop();
        }else{
            System.out.println("-----------get request---------");
            System.out.println(text);
        }
    }

    private static void stop() {
        exec.shutdown();
    }

    private static String readRequst(Socket connection) {
        String text;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            text = "error";
        }
        return text;
    }
}
