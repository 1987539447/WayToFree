package com.github.siemen.zenofdesignpattern.visitor;
/**
 * Created by Zhan on 2017-04-07.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者调用测试
 */
public class Client {
    public static void main(String[] args) {
        IShowVisitor showVisitor = new ShowVisitor();
        ITotalVistor totalVistor = new TotalVisitor();
        for (Employee employee : mockEmploye()) {
            employee.accept(showVisitor);
            employee.accept(totalVistor);
        }
        showVisitor.report();
        totalVistor.totalSalary();
    }

    private static List<Employee> mockEmploye() {
        List<Employee> mockEmploye = new ArrayList<>();

        CommonEmployee zhang = new CommonEmployee();
        zhang.setName("张三");
        zhang.setJob("研发");
        zhang.setSalary(1000);
        zhang.setSex(1);
        mockEmploye.add(zhang);

        Manager wang = new Manager();
        wang.setName("王五");
        wang.setPerformance("业绩可以~");
        wang.setSex(0);
        wang.setSalary(2000);
        mockEmploye.add(wang);

        return mockEmploye;
    }
}
