package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 用户操作接口实现
 */
public class UserProvider implements IUserProvider {

    private List<User> userList;

    public UserProvider(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public List<User> findUser(IUserSpecification specification) {

        List<User> result = new ArrayList<>();
        for (User user : userList) {
            if(specification.isSatisfiedBy(user)){
                result.add(user);
            }
        }

        return result;
    }
}
