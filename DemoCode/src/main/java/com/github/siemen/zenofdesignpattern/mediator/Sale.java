package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

import java.util.Random;

/**
 * 销售协同类
 */
public class Sale extends AbstractColleage {

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    public void sellComputer(int number){
        super.mediator.execute("SELL",number);
        System.out.println("销售电脑"+number+"台");
    }

    public int getSaleStatus(){
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("电脑销售状况为："+saleStatus);
        return saleStatus;
    }

    public void offSale(){
        super.mediator.execute("OFFSELL");
    }
}
