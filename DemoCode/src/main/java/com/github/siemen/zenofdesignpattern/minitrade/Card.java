package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 一卡通实体
 */
public class Card {
    private String cardNo;
    private int steadyMoney;
    private int freeMoney;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getSteadyMoney() {
        return steadyMoney;
    }

    public void setSteadyMoney(int steadyMoney) {
        this.steadyMoney = steadyMoney;
    }

    public int getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(int freeMoney) {
        this.freeMoney = freeMoney;
    }

    @Override
    public String toString() {
        return "IC卡信息{" +
                "卡编号='" + cardNo + '\'' +
                ", 固定金额=" + steadyMoney +
                ", 自由金额=" + freeMoney +
                '}';
    }
}
