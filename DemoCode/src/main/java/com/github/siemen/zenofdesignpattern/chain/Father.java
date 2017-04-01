package com.github.siemen.zenofdesignpattern.chain;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 父亲处理类
 */
public class Father extends Handler {


    public Father() {
        super(Handler.FATHER_LEVEL_REQUSET);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("------------女儿向父亲请示---------");
        System.out.println(women.getRequest());
        System.out.println("父亲答复是同意");
    }
}
