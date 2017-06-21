package com.github.siemen.oom;
/**
 * Created by Zhan on 2017-04-24.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区-运行时常量溢出
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i).intern());
        }
    }
}
