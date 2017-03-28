package com.github.siemen.zenofdesignpattern.srp;

/**
 * Created by Zhan on 2017-03-28.
 */
public interface IConnectionManager {
    void dial(String phoneNumber);

    void hangup();
}
