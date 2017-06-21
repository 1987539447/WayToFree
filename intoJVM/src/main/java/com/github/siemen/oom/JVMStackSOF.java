package com.github.siemen.oom;
/**
 * Created by Zhan on 2017-04-24.
 */

/**
 * jvm 栈溢出
 */
public class JVMStackSOF {

    private int stackLength = 1;

    private void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JVMStackSOF sof = new JVMStackSOF();
        try {
            sof.stackLeak();
        }catch (Throwable ex){
            System.out.println("stack length :"+sof.stackLength);
            ex.printStackTrace();
        }
    }
}
