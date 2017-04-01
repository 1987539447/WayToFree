package com.github.siemen.zenofdesignpattern.template;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * 悍马模型类，提供实现模板
 */
public abstract class HummerModel {
    /**基本方法*/
    protected abstract void start();
    protected abstract void stop();
    protected abstract void enginBoom();
    protected abstract void alarm();
    /**钩子方法，控制行为*/
    protected boolean isAlarm(){
        return true;
    }
    /**模板方法-整体算法框架*/
    public void run(){
        this.start();
        this.enginBoom();
        if(isAlarm()){
            this.alarm();
        }
        this.stop();
    }
}
