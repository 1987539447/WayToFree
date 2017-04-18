package com.github.siemen.zenofdesignpattern.minitrade;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 策略工厂：根据枚举产生策略实例
 */
public class StrategyFactory {
    public static IDeduction getDedution(StrategyMan strategyMan){
        IDeduction deduction = null;
        try {
            deduction = (IDeduction) Class.forName(strategyMan.getValue()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return deduction;
    }
}
