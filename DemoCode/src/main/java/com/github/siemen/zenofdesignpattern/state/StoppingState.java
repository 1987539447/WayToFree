package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 *停止状态
 */
public class StoppingState extends LiftState{

    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.open();
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止……");
    }
}
