package com.github.siemen.zenofdesignpattern.chain;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 儿子处理类
 */
public class Son extends Handler {

    public Son() {
        super(Handler.SON_LEVEL_REQUSET);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("------------母亲向儿子请示---------");
        System.out.println(women.getRequest());
        System.out.println("儿子答复是同意");
    }
}
