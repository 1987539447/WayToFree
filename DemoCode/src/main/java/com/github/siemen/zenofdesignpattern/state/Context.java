package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 * 状态封装类
 */
public class Context {

    public static final OpenningState openningState = new OpenningState();
    public static final ClosingState closingState = new ClosingState();
    public static final RunningState runningState = new RunningState();
    public static final StoppingState stoppingState = new StoppingState();

    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open(){
        liftState.open();
    }

    public void close(){
        liftState.close();
    }

    public void run(){
        liftState.run();
    }

    public void stop(){
        liftState.stop();
    }
}
