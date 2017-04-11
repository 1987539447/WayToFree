package com.github.siemen.zenofdesignpattern.bridge;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 抽象公司类
 */
public abstract class Corp {

    protected Product product;

    public Corp(Product product){
        this.product = product;
    }

    public void makeMoney(){
        this.product.beProducted();
        this.product.beSelled();
    }
}
