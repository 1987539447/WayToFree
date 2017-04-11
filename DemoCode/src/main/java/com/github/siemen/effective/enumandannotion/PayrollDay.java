package com.github.siemen.effective.enumandannotion;

/**
 * Created by Zhan on 2017-04-05.
 * 私有枚举实现枚举策略
 */
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payTyep;

    PayrollDay(PayType payType) {
        this.payTyep = payType;
    }

    public double pay(double hours,double payRate){
        return this.payTyep.pay(hours,payRate);
    }

    private enum PayType{
        WEEKDAY {
            @Override
            double overTimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            double overTimePay(double hours, double payRate) {
                return 0;
            }
        };
        private static final int HOURS_PER_SHIFT = 8;
        abstract double overTimePay(double hours,double payRate);
        double pay(double hoursWorked,double payRate){
            double basePay = hoursWorked * payRate;
            return basePay + overTimePay(hoursWorked,payRate);
        }
    }

    public static void main(String[] args) {
        System.out.println(MONDAY+":"+MONDAY.pay(9,10));
    }
}
