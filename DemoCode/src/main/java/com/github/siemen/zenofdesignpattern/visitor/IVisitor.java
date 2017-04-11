package com.github.siemen.zenofdesignpattern.visitor;

/**
 * Created by Zhan on 2017-04-07.
 * 访问者抽象接口
 */
public interface IVisitor {

    void visit(CommonEmployee employee);
    void visit(Manager manager);
}
