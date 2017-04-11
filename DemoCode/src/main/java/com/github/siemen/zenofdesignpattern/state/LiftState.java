package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 * 电梯状态抽象类
 */
public abstract class LiftState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
