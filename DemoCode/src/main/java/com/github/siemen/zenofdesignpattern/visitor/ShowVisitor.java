package com.github.siemen.zenofdesignpattern.visitor;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 信息展示访问者实现
 */
public class ShowVisitor implements IShowVisitor {

    private StringBuilder info = new StringBuilder();

    @Override
    public void report() {
        System.out.println(info.toString());
    }

    @Override
    public void visit(CommonEmployee employee) {
        this.getBasicInfo(employee);
        info.append("工作：").append(employee.getJob())
        .append("\t\n");
    }



    @Override
    public void visit(Manager manager) {
        this.getBasicInfo(manager);
        info.append("业绩：").append(manager.getPerformance())
                .append("\t\n");
    }

    private void getBasicInfo(Employee employee) {
        info.append("姓名：").append(employee.getName())
                .append("\t性别：").append(employee.getSex())
                .append("\t薪水：").append(employee.getSalary()).append("\t");
    }
}
