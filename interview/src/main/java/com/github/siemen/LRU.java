package com.github.siemen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhan on 2017/2/23 0023.
 * 操作系统LRU（Least Recently Used）内存淘汰策略
 * 假定内存大小为5，依次访问数据，顺序如下：
 * 1,2,5,3,4,6,1,4,3,6,7,8,3,9
 * 访问过程中发生缺页的次数是？
 *
 * 根据云栖 小柒2012代码
 */
public class LRU {

    public static void main(String[] args) {
        LimitQueue<Integer> mem = new LimitQueue<Integer>(5);
        Integer[] accData = new Integer[]{1,2,5,3,4,6,1,4,3,6,7,8,3,9};
        List<Integer> page = new ArrayList<Integer>();

        for (Integer data : accData) {
            if(mem.contains(data)){
                mem.remove(data);
            }else{
                page.add(data);
            }
            mem.offer(data);
        }

        System.out.println("缺页数量："+page.size()+",发生缺页的数据:"+page.toString());
    }
}
