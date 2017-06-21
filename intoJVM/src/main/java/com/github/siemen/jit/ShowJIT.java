package com.github.siemen.jit;
/**
 * Created by Zhan on 2017-05-16.
 */

/**
 * 显示即时编译信息
 */
public class ShowJIT {

    public static final int NUM = 15000;


    public static int doubleValue(int i){

        for (int j = 0; j < 100000; j++);//无效循环，会被优化消除
        return i * 2;
    }

    public static long calcSum(){
        long sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    /**
     * -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompilation -XX:+PrintInlining
     * 显示即时编译和方法内联信息
     * */
    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }

}
