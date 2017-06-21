package com.github.siemen.visibility;
/**
 * Created by Zhan on 2017-06-19.
 */

/**
 * 变量可见性
 * 线程运行存在风险，number ready赋值没有关联，有可能会被重排序
 * 并没有出现
 */
public class NotVisibility {

    private static boolean ready;
    private static int number;

    private static class ReadRender extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReadRender().start();
        number = 24;
        ready = true;

    }
}
