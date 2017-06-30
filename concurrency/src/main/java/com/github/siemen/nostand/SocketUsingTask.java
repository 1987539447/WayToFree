package com.github.siemen.nostand;
/**
 * Created by Zhan on 2017-06-23.
 */

import com.github.siemen.annotation.GuardedBy;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * 可取消的Socket任务
 */
public abstract class SocketUsingTask<T> implements CancellableTask<T> {

    @GuardedBy("this")
    private Socket socket;

    public synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void cancel() {
        if(this.socket != null ){
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public RunnableFuture<T> newTask() {

        return new FutureTask<T>(this){
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.cancel();
                }finally {
                    return super.cancel(mayInterruptIfRunning);
                }

            }
        };
    }

}
