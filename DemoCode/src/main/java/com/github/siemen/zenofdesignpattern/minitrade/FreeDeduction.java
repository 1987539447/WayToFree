package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 扣款策略二：只从自由金额扣除
 */
public class FreeDeduction implements IDeduction {
    @Override
    public boolean exec(Card card, Trade trade) {
        card.setFreeMoney(card.getFreeMoney() - trade.getAmount());
        return true;
    }
}
