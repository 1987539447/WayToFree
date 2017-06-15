package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 规格调用客户端
 */
public class Client {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User("张三",20));
        userList.add(new User("李三",23));
        userList.add(new User("王三",23));
        userList.add(new User("赵六",22));
        userList.add(new User("钱八",25));
        userList.add(new User("孙九",27));
        userList.add(new User("周十",30));
        System.out.println("----------初始化用户信息---------------");
        userList.forEach(System.out::println);

        IUserProvider provider = new UserProvider(userList);
        System.out.println("----------搜索名字包含‘三’，年龄大于22的人--------------");
        IUserSpecification ageSpec = new AgeGreater(22);
        IUserSpecification nameSpec = new UserNameLike("%三%");
        provider.findUser(ageSpec.and(nameSpec)).forEach(System.out::println);
    }
}
