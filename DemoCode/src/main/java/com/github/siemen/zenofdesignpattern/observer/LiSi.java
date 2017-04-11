package com.github.siemen.zenofdesignpattern.observer;
/**
 * Created by Zhan on 2017-04-06.
 */

import java.util.Observable;
import java.util.Observer;

/**
 * 李斯-观察者
 */
public class LiSi implements Observer {

    @Override
    public void update(Observable han, Object msg) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报~");
        this.reportToQin(msg);
        System.out.println("李斯：汇报完毕，终止韩非子活动~");
        ((IHanFeiZi)han).stop();
    }

    private void reportToQin(Object msg) {
        System.out.println("李斯：报告，秦老大，韩非子有活动----->"+msg);
    }
}
