package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * And逻辑规格实现
 */
public class AndSpecification extends CompositeSpecification implements IUserSpecification {

    private IUserSpecification left;
    private IUserSpecification right;

    public AndSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) && right.isSatisfiedBy(user);
    }
}
