package com.github.siemen.ext;
/**
 * Created by Zhan on 2017-06-21.
 */

import com.github.siemen.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 客户端加锁实现缺少即加入
 * 错误的实现-必须使用同一把锁
 *
 */
@NotThreadSafe
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    /*错误实现，没使用同一把锁*/
    public synchronized boolean wrongPutIfAbsent(E e){
        boolean absent = !list.contains(e);
        if(absent){
            list.add(e);
        }
        return absent;
    }

    /*正确实现，使用底层list锁*/
    public boolean putIfAbsent(E e){
        synchronized (list){
            boolean absent = !list.contains(e);
            if(absent){
                list.add(e);
            }
            return absent;
        }

    }
}
