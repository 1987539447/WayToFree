package com.github.siemen.latch;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 对耗时长的操作预先处理
 * 通过单独线程启动对produect信息加载，可先启动执行
 * 通过future.get 阻塞获取结果
 */
public class PreLoader {



    private final FutureTask<ProuductInfo> future = new FutureTask<>(() -> loadProductInfo());
    private final Thread thread = new Thread(future);
    public void start(){
        thread.start();
    }
    public ProuductInfo get() throws ExecutionException, InterruptedException {
        return future.get();
    }



    private class ProuductInfo {
        private String name;
        private double price;

        private ProuductInfo(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private ProuductInfo loadProductInfo() throws InterruptedException {
        Thread.sleep(1000);
        return new ProuductInfo("macPro", 3000.00);
    }
}
