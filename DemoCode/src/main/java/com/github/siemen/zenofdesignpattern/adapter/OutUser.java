package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 外部职工类
 */
public class OutUser implements IOutUser {
    @Override
    public Map<String, String> getUserBaseInfo() {
        Map<String,String> userBaseInfo = new HashMap<>();
        userBaseInfo.put("userName","张无忌");
        return userBaseInfo;
    }

    @Override
    public Map<String, String> getOfficeInfo() {
        Map<String,String> officeInfo = new HashMap<>();
        officeInfo.put("officeTel","1123108");
        return officeInfo;
    }
}
