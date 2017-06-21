package com.github.siemen.exec;
/**
 * Created by Zhan on 2017-05-11.
 */

/**
 *Slot被重用
 */
public class ReUseSlot {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 *1024];
        }
        //Slot没复用，placeholder仍被引用，不会回收
        int a = 0;//重用Slot
        System.gc();
    }
}
