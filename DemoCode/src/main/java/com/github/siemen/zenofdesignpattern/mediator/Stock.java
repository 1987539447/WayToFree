package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 库存协同类
 */
public class Stock extends AbstractColleage{

    private  static int COMPUTER_NUMBER = 100;

    public Stock(AbstractMediator mediator) {
        super(mediator);
    }

    public void increase(int numer){
        COMPUTER_NUMBER += numer;
        System.out.println("库存数量为："+COMPUTER_NUMBER);
    }

    public void decrease(int numer){
        COMPUTER_NUMBER -= numer;
        System.out.println("库存数量为："+COMPUTER_NUMBER);
    }

    int getStockNumber(){
        return COMPUTER_NUMBER;
    }

    void clearStock(){
        System.out.println("清理存货数量为:"+COMPUTER_NUMBER);
        super.mediator.execute("CLEAR");
    }
}
