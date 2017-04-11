package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 外部职工办公信息
 */
public class OutUserOfficeInfo implements IOutUserOfficeInfo {
    @Override
    public Map<String, String> getOfficeInfo() {
        Map<String,String> officeInfo = new HashMap<>();
        officeInfo.put("officeTel","1123108");
        return officeInfo;
    }
}
