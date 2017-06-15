package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * NOT逻辑规格实现
 */
public class NotSpecification extends CompositeSpecification implements IUserSpecification {

    private IUserSpecification specification;

    public NotSpecification(IUserSpecification specification) {
        this.specification = specification;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return !specification.isSatisfiedBy(user);
    }
}
