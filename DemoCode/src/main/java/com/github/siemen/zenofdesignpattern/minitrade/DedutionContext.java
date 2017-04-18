package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 扣款策略封装
 */
public class DedutionContext {
    private IDeduction deduction;

    public DedutionContext(IDeduction deduction){
        this.deduction = deduction;
    }

    public boolean exec(Card card,Trade trade){
        return this.deduction.exec(card,trade);
    }
}
