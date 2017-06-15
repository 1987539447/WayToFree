package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * Or逻辑规格实现
 */
public class OrSpecification extends CompositeSpecification implements IUserSpecification {

    private IUserSpecification left;
    private IUserSpecification right;

    public OrSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
    }
}
