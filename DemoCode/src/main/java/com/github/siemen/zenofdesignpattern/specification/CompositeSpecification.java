package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * 规格接口基类实现
 */
public abstract class CompositeSpecification implements IUserSpecification {

    @Override
    public IUserSpecification and(IUserSpecification specification) {
        return new AndSpecification(this,specification);
    }

    @Override
    public IUserSpecification or(IUserSpecification specification) {
        return new OrSpecification(this,specification);
    }

    @Override
    public IUserSpecification not() {
        return new NotSpecification(this);
    }
}
