package com.github.siemen.zenofdesignpattern.onfire;

/**
 * Created by Zhan on 2017-04-18.
 * 具体事件处理者类别
 */
public enum EventCustomType {
    NEW(1),
    DEL(2),
    EDIT(3),
    CLONE(4);

    private final int value;

    EventCustomType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
