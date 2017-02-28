package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 * 测试静态引用
 */
public class TestStaticRef {


    public static void main(String[] args) {
        PersonFactory<Person> factory = Person::new;
        Person person = factory.create("leo","skt");
        System.out.println(person);
    }
}
