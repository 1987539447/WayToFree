package com.github.siemen.gc;
/**
 * Created by Zhan on 2017-04-24.
 */

/**
 * 通过finalize逃过GC
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        //仅被JVM执行一次
        super.finalize();
        System.out.println("finalize method execute~~~~");
        SAVE_HOOK = this;//重新建立关联
    }

    public void  isAlive(){
        System.out.println("yes,i am still alive~~");
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;//销毁引用
        System.gc();//gc 触发finalize
        Thread.sleep(500);//finalize优先级低，等待

        if(SAVE_HOOK == null){
            System.out.println("no,i am dead~~");
        }else{
            SAVE_HOOK.isAlive();
        }

        SAVE_HOOK = null;//再次销毁
        System.gc();
        Thread.sleep(500);//finalize优先级低，等待

        if(SAVE_HOOK == null){
            System.out.println("no,i am dead~~");
        }else{
            SAVE_HOOK.isAlive();
        }


    }
}
