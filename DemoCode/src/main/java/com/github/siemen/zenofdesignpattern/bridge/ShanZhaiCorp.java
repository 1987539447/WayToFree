package com.github.siemen.zenofdesignpattern.bridge;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 山寨公司
 */
public class ShanZhaiCorp extends Corp {

    public ShanZhaiCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("山寨公司赚快钱~~");
    }
}
