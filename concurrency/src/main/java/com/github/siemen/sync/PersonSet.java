package com.github.siemen.sync;
/**
 * Created by Zhan on 2017-06-19.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 实例限制，不共享状态，仅提供安全的访问方法
 * 类似Collections.synchronizeedList等方法
 */
public class PersonSet {

    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person person){
        mySet.add(person);
    }

    public synchronized boolean containsPerson(Person person){
        return mySet.contains(person);
    }

    private class Person {
    }
}
