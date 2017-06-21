package com.github.siemen.tools;
/**
 * Created by Zhan on 2017-04-26.
 */

import java.util.Map;

/**
 * 显示线程堆栈信息 -jsp
 */
public class ShowStack {
    public static void main(String[] args) {
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread thread = entry.getKey();
            if(thread.equals(Thread.currentThread())){
                continue;
            }
            StackTraceElement[] stack = entry.getValue();
            System.out.println("线程："+thread.getName());
            for (StackTraceElement element : stack) {
                System.out.println("\t"+element);
            }
        }
    }
}
