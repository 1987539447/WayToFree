package com.github.siemen.oom;
/**
 * Created by Zhan on 2017-04-24.
 */

/**
 *jvm内存溢出 OOM
 */
public class JavaVMStackOOM {

    private void notStop(){
        while (true){}
    }

    public  void staticLeakByThread() {
        while (true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    notStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        //oom.staticLeakByThread();//会导致系统假死
    }
}
