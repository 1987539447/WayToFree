package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * 业务规格实现-姓名相同
 */
public class UserByNameEqual extends CompositeSpecification {

    private String name;

    public UserByNameEqual(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().equals(this.name);
    }
}
