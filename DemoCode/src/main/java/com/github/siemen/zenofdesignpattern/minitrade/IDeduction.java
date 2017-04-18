package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 扣款策略接口
 */
public interface IDeduction {

    boolean exec(Card card,Trade trade);
}
