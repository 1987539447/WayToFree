package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-26.
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 用信号量约束容器，变为阻塞容器
 * 通过信号量数量限制底层容器大小
 * 增加原色前先获取许可
 * 成功删除后释放许可
 */
public class BoundedHashSet<E> {
    private final Set<E> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bound){
        this.set = Collections.synchronizedSet(new HashSet<E>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(E e) throws InterruptedException{
        this.semaphore.acquire();
        boolean wasAdded = true;
        try {
            wasAdded = set.add(e);
            return wasAdded;
        }finally {
            if(!wasAdded){
                this.semaphore.release();
            }
        }
    }

    public boolean remove(E e) throws InterruptedException{
        boolean wasRemoved = set.remove(e);
        if(wasRemoved){
            this.semaphore.release();
        }
        return wasRemoved;
    }
}
