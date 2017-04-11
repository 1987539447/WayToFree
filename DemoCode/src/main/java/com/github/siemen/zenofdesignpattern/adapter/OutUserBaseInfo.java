package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 外部职工基本信息
 */
public class OutUserBaseInfo implements IOutUserBaseInfo {
    @Override
    public Map<String, String> getUserBaseInfo() {
        Map<String,String> userBaseInfo = new HashMap<>();
        userBaseInfo.put("userName","张无忌");
        return userBaseInfo;
    }
}
