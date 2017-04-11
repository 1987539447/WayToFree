package com.github.siemen.zenofdesignpattern.visitor;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 工资计算访问者
 */
public class TotalVisitor implements ITotalVistor {

    private final static int MANAGER_COEFFICINENT = 5;
    private final static int COMMONEMPLOYE_COEEFICINENT = 2;
    private int commonTotalSalary = 0;
    private int managerTotalSalary = 0;

    @Override
    public void totalSalary() {
        System.out.println("本公司的月工资总额是："+(this.commonTotalSalary + this.managerTotalSalary));
    }

    @Override
    public void visit(CommonEmployee employee) {
        this.commonTotalSalary += employee.getSalary(COMMONEMPLOYE_COEEFICINENT);
    }

    @Override
    public void visit(Manager manager) {
        this.managerTotalSalary += manager.getSalary(MANAGER_COEFFICINENT);
    }
}
