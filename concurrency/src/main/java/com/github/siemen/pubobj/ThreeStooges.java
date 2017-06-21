package com.github.siemen.pubobj;
/**
 * Created by Zhan on 2017-06-19.
 */

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 构建与可变对象上的不可变类
 * set是可变的，但通过private final定义并通过构造函数初始化
 * 不提供修改访问方则stooges不可变
 */
@Immutable
public class ThreeStooges {

    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges(){
        stooges.add("More");
        stooges.add("Cur");
        stooges.add("Larry");
    }

    public boolean isStooge(String name){
        return stooges.contains(name);
    }

}
