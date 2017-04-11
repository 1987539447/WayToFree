package com.github.siemen.zenofdesignpattern.expression;
/**
 * Created by Zhan on 2017-04-10.
 */

import java.util.Map;

/**
 * 变量解释器
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return var.get(key);
    }
}
