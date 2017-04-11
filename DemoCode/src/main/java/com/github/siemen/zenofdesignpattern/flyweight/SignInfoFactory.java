package com.github.siemen.zenofdesignpattern.flyweight;
/**
 * Created by Zhan on 2017-04-11.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class SignInfoFactory {

    private static Map<String,SignInfo> pool = new HashMap<>();

    public static SignInfo getSignInfo(String key){
        if(pool.containsKey(key)){
            System.out.println(key+"---直接从对象池获取----");
            return pool.get(key);
        }else{
            System.out.println(key+"----建立对象，并缓存到对象池-----");
            return pool.put(key,new SignInfo4Pool(key));
        }
    }
}
