package com.github.siemen.zenofdesignpattern.observer;
/**
 * Created by Zhan on 2017-04-06.
 */

import java.util.Observable;

/**
 * 韩非子实现类 - 被观察者
 */
public class HanFeiZi extends Observable implements IHanFeiZi {

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭~");
        super.setChanged();
        super.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子开始娱乐~");
        super.setChanged();
        super.notifyObservers("韩非子在娱乐");
    }

    @Override
    public void stop() {
        System.out.println("活动被终止~");
    }
}
