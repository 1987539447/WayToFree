package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 扣款策略一：固定金额自由金额各扣50%
 */
public class SteadyDeduction implements IDeduction{

    @Override
    public boolean exec(Card card, Trade trade) {
        int halfMoney = (int) Math.rint(trade.getAmount()/2.0);
        card.setSteadyMoney(card.getSteadyMoney() - halfMoney);
        card.setFreeMoney(card.getFreeMoney() - halfMoney);
        return true;
    }
}
