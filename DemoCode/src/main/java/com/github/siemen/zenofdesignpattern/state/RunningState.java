package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 * 运行状态
 */
public class RunningState extends LiftState {

    @Override
    public void open() {
        //do nothign
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        System.out.println("电梯运行……");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
