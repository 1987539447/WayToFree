package com.github.siemen.zenofdesignpattern.expression;
/**
 * Created by Zhan on 2017-04-10.
 */

import java.util.Map;

/**
 * 解释器抽象类
 */
public abstract class Expression {
    public abstract int interpreter(Map<String, Integer> var);
}
