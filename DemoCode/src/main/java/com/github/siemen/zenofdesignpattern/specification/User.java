package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * 用户实体类
 */
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "用户{" +
                "姓名='" + name + '\'' +
                ", 年龄=" + age +
                '}';
    }
}
