package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 中介者抽象
 */
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator(){
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }

    public abstract void execute(String action,Object...objects);
}
