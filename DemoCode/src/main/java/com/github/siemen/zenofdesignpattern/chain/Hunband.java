package com.github.siemen.zenofdesignpattern.chain;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 丈夫处理类
 */
public class Hunband extends Handler {

    public Hunband() {
        super(Handler.HUSBAND_LEVEL_REQUSET);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("------------妻子向丈夫请示---------");
        System.out.println(women.getRequest());
        System.out.println("丈夫答复是同意");
    }
}
