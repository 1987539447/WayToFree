package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 客户端类
 */
public class Client {
    public static void main(String[] args) {
        AbstractMediator mediator = new Mediator();
        System.out.println("------------采购人员采购电脑--------");
        Purchase purchase = new Purchase(mediator);
        purchase.buyComputer(100);
        System.out.println("---------销售人员销售电脑-----------");
        Sale sale = new Sale(mediator);
        sale.sellComputer(1);
        System.out.println("--------库房管理人员清理库存--------");
        Stock stock = new Stock(mediator);
        stock.clearStock();
    }
}
