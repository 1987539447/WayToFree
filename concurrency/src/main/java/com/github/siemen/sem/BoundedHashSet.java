package com.github.siemen.sem;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 通过信号量构建有限容器
 * 信号量控制可存入元素总数
 * 增加元素先获取许可，如增加失败-异常需要释放许可
 * 删除元素成功 直接释放许可
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        semaphore.acquire();
        boolean wasAdded = false;
        try{
            wasAdded = set.add(t);
            return wasAdded;
        }finally {
            if(!wasAdded){
                semaphore.release();
            }
        }
    }

    public boolean remove(T t) {
        boolean wasRemoved = set.remove(t);
        if(wasRemoved){
            semaphore.release();
        }
        return wasRemoved;

    }
}
