package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 中介者实现类
 */
public class Mediator extends AbstractMediator {
    @Override
    public void execute(String action, Object... objects) {
        switch (action){
            case "BUY":
                this.buyComputer((Integer)objects[0]);
                break;
            case "SELL":
                this.sellComputer((Integer)objects[0]);
                break;
            case "OFFSELL":
                this.offSell();
                break;
            case "CLEAR":
                this.clearStock();
                break;
        }
    }

    private void clearStock() {
        super.sale.offSale();
        super.purchase.refuseBuy();
    }

    private void offSell() {
        System.out.println("打折销售电脑"+super.stock.getStockNumber()+"台");
    }

    private void sellComputer(int number) {

        if(super.stock.getStockNumber()<number){
            super.purchase.buyComputer(number);
        }
        super.stock.decrease(number);
    }

    private void buyComputer(int number) {
        int sellStatus = super.sale.getSaleStatus();
        if(sellStatus>80){
            System.out.println("采购电脑"+number+"台~");
            super.stock.increase(number);
        }else{
            int buyNumber = number/2;
            System.out.printf("采购电脑"+buyNumber+"台~");
            super.stock.increase(buyNumber);
        }
    }
}
