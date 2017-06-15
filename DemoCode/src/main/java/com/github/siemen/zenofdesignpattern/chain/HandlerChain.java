package com.github.siemen.zenofdesignpattern.chain;
/**
 * Created by Zhan on 2017-04-01.
 */

import java.util.function.Consumer;

/**
 * 构建责任链
 */
public class HandlerChain {

    private static Handler father = new Father();
    private static Handler husband = new Hunband();
    private static Handler son = new Son();
    static{
        father.setNext(husband);
        husband.setNext(son);
    }

    public static void handleMessage(IWomen women){
        father.HandleMessage(women);
    }

/*    @Override
    public void accept(IWomen women) {
        father.HandleMessage(women);
    }*/
}
