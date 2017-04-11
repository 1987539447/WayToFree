package com.github.siemen.zenofdesignpattern.state;
/**
 * Created by Zhan on 2017-04-10.
 */

/**
 * 状态调用客户端
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(Context.stoppingState);
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
