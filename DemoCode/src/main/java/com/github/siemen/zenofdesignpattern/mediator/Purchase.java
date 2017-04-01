package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 采购对象
 */
public class Purchase extends AbstractColleage {

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    public void buyComputer(int number){
        super.mediator.execute("BUY",number);
    }

    public void refuseBuy(){
        System.out.println("不再购买电脑~");
    }
}
