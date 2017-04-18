package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

import com.sun.org.apache.bcel.internal.generic.InstructionComparator;

import java.util.Scanner;

/**
 * mini交易系统-模式混编
 * 策略模式-工厂方法模式-(状态模式-责任链模式)-门面模式
 */
public class MiniTrade {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Card card = initCard();
        System.out.println("--------初始化卡信息----------");
        System.out.println(card);
        boolean flag = true;
        while (flag){
            Trade trade = createTrade();
            DeductionFacade.deduct(card,trade);
            System.out.println("----------交易凭证--------");
            System.out.println(trade.getTradeNo()+"交易成功！");
            System.out.println("本次交易发生金额为："+trade.getAmount()/100.0+"元");
            System.out.println(card);
            System.out.println("是否需要退出？（Y/N）");
            if(getInput().equalsIgnoreCase("Y")){
                flag = false;
                System.out.println("---------系统退出 Bye---------");
            }
        }

    }

    private static String getInput() {
        return scanner.nextLine();
    }

    private static Trade createTrade() {
        Trade trade = new Trade();
        System.out.println("-----------请输入交易编号---------");
        trade.setTradeNo(getInput());
        System.out.println("-----------请输入交易金额---------");
        trade.setAmount(Integer.parseInt(getInput()));
        return trade;
    }

    private static Card initCard() {
        Card card = new Card();
        card.setCardNo("123455");
        card.setFreeMoney(200000);
        card.setSteadyMoney(100000);
        return card;
    }
}
