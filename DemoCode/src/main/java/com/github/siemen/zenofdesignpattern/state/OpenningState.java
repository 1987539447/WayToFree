package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 * 敞开状态
 */
public class OpenningState extends LiftState {

    @Override
    public void open() {
        System.out.println("电梯门开启……");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closingState);
        super.context.close();
    }

    @Override
    public void run() {
        //do nothing
    }

    @Override
    public void stop() {
        //do nonthing
    }
}
