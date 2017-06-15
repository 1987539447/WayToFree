package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * 业务规格-年龄大于
 */
public class AgeGreater extends CompositeSpecification {

    private int age;

    public AgeGreater(int age) {
        this.age = age;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge()>this.age;
    }
}
