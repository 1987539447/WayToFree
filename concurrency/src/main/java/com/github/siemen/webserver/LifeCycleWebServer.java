package com.github.siemen.webserver;
/**
 * Created by Zhan on 2017-06-22.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * 可关闭的webserver
 * 通过ExecutorService提供生命周期管理
 */
public class LifeCycleWebServer {
    private static final int N_THREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(N_THREADS);

    public  void start(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (!exec.isShutdown()){
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            try{
                exec.execute(task);
            }catch (RejectedExecutionException e){
                if(!exec.isShutdown()){
                    log("task submission rejected",e);
                }
            }

        }
    }

    public void stop(){
        exec.shutdown();
    }

    private void log(String msg,Exception ex){
        System.out.println(msg+ex.getMessage());
        //ex.printStackTrace();
    }

    private  void handleRequest(Socket connection) {
        System.out.println("----handling request----");
        String request = readRequst(connection);
        if(isShutdownRequest(request)){
            stop();
        }else{
            dispatcherRequest(request);
        }
    }

    private void dispatcherRequest(String request) {
    }

    private boolean isShutdownRequest(String request) {
        return "stop".equals(request);
    }

    private static String readRequst(Socket connection) {
        return "";
    }
}
