package com.github.siemen.effective.enumandannotion;

/**
 * Created by Zhan on 2017-04-05.
 */
public enum ExtendOper implements IOperate {

    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x,y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private String symbol;

    ExtendOper(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return this.symbol;
    }

    public static void main(String[] args) {
        double x = 12.123;
        double y = 4.2342;
        test(ExtendOper.class,x,y);
    }

    private static <T extends Enum<T> & IOperate> void test(Class<T> clazz, double x, double y) {
        for (T oper : clazz.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",x,oper,y,oper.apply(x,y));
        }
    }
}
