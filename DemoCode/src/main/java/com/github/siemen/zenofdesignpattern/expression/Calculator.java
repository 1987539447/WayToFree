package com.github.siemen.zenofdesignpattern.expression;
/**
 * Created by Zhan on 2017-04-10.
 */

import com.github.siemen.effective.generics.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器封装类
 */
public class Calculator {
    private Expression expression;

    public Calculator(String expStr){
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();
        Expression left = null;
        Expression rignt = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]){
                case '+':
                    left = stack.pop();
                    rignt = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,rignt));
                    break;
                case '-':
                    left = stack.pop();
                    rignt = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,rignt));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        this.expression = stack.pop();
    }

    public int run(Map<String,Integer> var){
        return this.expression.interpreter(var);
    }
}
