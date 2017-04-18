package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 扣款模块封装门面
 */
public class DeductionFacade {

    public static Card deduct(Card card,Trade trade){
        StrategyMan reg = getDeductionType(trade);
        IDeduction deduction = StrategyFactory.getDedution(reg);
        DedutionContext context = new DedutionContext(deduction);
        context.exec(card,trade);
        return card;
    }

    //根据交易选择扣款策略
    private static StrategyMan getDeductionType(Trade trade) {
        if(trade.getTradeNo().startsWith("abc")){
            return StrategyMan.FreeDedution;
        }
        return StrategyMan.SteadyDedution;
    }
}
