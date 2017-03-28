package com.github.siemen.thread;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Zhan on 2017/3/21 0021.
 */
public class CompletableFutureTest {

    public static CompletableFuture<Integer> compute(){
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return  future;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
/*        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            int i = 1/0;
            return  100;
        });
        //future.get();
        future.join();*/

        final CompletableFuture<Integer> future = compute();
        class Client extends Thread{
            CompletableFuture<Integer> future;
            public Client(String threadName,CompletableFuture future){
                super(threadName);
                this.future = future;
            }
            @Override
            public void run(){
                try {
                    System.out.println(this.getName()+": "+future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("client1",future).start();
        new Client("client2",future).start();
        System.out.println("waiting.....");
        future.complete(100);
        //System.in.read();
    }
}
