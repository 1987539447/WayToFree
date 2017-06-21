package com.github.siemen.oom;
/**
 * Created by Zhan on 2017-04-24.
 */

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存溢出
 */
public class DirectMemoryOOM {

    private static final int int_1MB = 1024*1024;

    /**
     * -Xmx20M -XX:MaxDirectMemory=10M
     * */
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(int_1MB);
        }

    }
}
