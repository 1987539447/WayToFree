package com.github.siemen.zenofdesignpattern.onfire;

/**
 * Created by Zhan on 2017-04-18.
 * 产品事件类型枚举
 */
public enum ProductEventType {
    NEW_PRODUCT(1),
    DEL_PRODUCT(2),
    EDIT_PRODUCT(3),
    CLONE_PRODUCT(4);

    private final int value;

    ProductEventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
