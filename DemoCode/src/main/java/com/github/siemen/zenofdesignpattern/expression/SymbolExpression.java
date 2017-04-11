package com.github.siemen.zenofdesignpattern.expression;
/**
 * Created by Zhan on 2017-04-10.
 */

import java.util.Map;

/**
 * 运算符解释器
 */
public abstract class SymbolExpression extends Expression{

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }
}
