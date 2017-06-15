package com.github.siemen.zenofdesignpattern.specification;

/**
 * Created by Zhan on 2017-04-19.
 * 用户规格接口
 */
public interface IUserSpecification {

    boolean isSatisfiedBy(User user);
    IUserSpecification and(IUserSpecification specification);
    IUserSpecification or(IUserSpecification specification);
    IUserSpecification not();
}
