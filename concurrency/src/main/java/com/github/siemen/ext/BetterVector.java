package com.github.siemen.ext;
/**
 * Created by Zhan on 2017-06-21.
 */

import com.github.siemen.annotation.ThreadSafe;

import java.util.Vector;

/**
 * 为Vector类增加安全的缺少即加入方法putIfAbsent
 * 被继承类需要暴露足够的方法和状态
 * 同步策略被分散，需要使用相同的锁
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E e){
        boolean absent = !contains(e);
        if(absent){
            add(e);
        }
        return absent;
    }

}
