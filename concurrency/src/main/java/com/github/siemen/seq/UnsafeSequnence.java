package com.github.siemen.seq;
/**
 * Created by Zhan on 2017-06-16.
 */

import com.github.siemen.annotation.NotThreadSafe;

/**
 * 非线程安全的序列生成器
 * ++ 操作不是原子操作，并发时会导致值被覆盖
 */
@NotThreadSafe
public class UnsafeSequnence {
    private int value;
    public int getValue(){
        return value++;
    }
}
