package com.github.siemen.zenofdesignpattern.expression;
/**
 * Created by Zhan on 2017-04-10.
 */

import java.util.Map;

/**
 * 加法解释器
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
