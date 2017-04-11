package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 * 关闭状态
 */
public class ClosingState extends LiftState {

    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭……");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
