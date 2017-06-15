package com.github.siemen.zenofdesignpattern.specification;

import java.util.List;

/**
 * Created by Zhan on 2017-04-19.
 * 用户操作接口
 */
public interface IUserProvider {
    List<User> findUser(IUserSpecification specification);
}
