package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 * 测试构造函数引用
 */
public class Person {
    private String firstName;
    private String lastName;

    Person(){
        this.firstName="kamel";
        this.lastName = "jams";
    };
    Person(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
