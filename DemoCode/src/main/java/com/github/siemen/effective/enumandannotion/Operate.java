package com.github.siemen.effective.enumandannotion;

/**
 * Created by Zhan on 2017-04-05.
 */
public enum Operate implements IOperate {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x -y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private String symbol;

    Operate(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return this.symbol;
    }
}
