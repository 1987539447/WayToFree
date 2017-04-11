package com.github.siemen.effective.enumandannotion;

/**
 * Created by Zhan on 2017-04-05.
 */
public enum Operation {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x -y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return this.symbol;
    }

    abstract double apply(double x,double y);
}
