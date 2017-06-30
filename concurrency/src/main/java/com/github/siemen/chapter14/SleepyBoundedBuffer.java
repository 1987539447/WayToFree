package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-29.
 */

/**
 * 通过轮询加休眠阻塞操作
 * 轮询检测先验条件，不满足时休眠一段时间再检测
 * 客户端需要处理中断异常
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    private static final long SLEEP_GRANULARITY = 1000;

    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this){
                if(!isFull()){
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if(!isEmpty()){
                    return doTake();
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }


}
