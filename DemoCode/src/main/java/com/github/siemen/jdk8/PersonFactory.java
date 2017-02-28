package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 */
public interface PersonFactory <P extends Person> {

    P create(String firstName,String lastName);
    //P create();
}
