package com.github.siemen.zenofdesignpattern.bridge;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 房屋公司
 */
public class HouseCorp extends Corp {

    public HouseCorp(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱~~");
    }
}
