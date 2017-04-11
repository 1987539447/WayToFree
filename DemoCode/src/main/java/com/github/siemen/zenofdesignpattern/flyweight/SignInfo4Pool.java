package com.github.siemen.zenofdesignpattern.flyweight;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 共享对象
 */
public class SignInfo4Pool extends SignInfo {

    private final String key;//避免外部修改

    public String getKey() {
        return key;
    }

    public SignInfo4Pool(String key) {
        super();
        this.key = key;
    }
}
