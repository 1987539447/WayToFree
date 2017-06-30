package com.github.siemen.chapter15;
/**
 * Created by Zhan on 2017-06-30.
 */

/**
 * 通过CAS实现的计数器
 * 不阻塞操作，一直重试
 *
 */
public class CasCounter {
    private SimulateCAS value;
    public int getValue(){
        return value.get();
    }

    public int increment(){
        int v;
        do{
            v = value.get();
        }while (!value.compareAndSet(v,v+1));
        return v+1;
    }
}
