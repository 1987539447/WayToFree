package com.github.siemen.gc;
/**
 * Created by Zhan on 2017-04-25.
 */

/**
 * 内存分配与GC
 */
@SuppressWarnings("unused")
public class GCDetail {

    private static final int int_1MB = 1024*1024;
    /**
     * -XX:+UseSerialGC
     * */
    public static void main(String[] args) {
        System.out.println("中国");
        //testAllocation();
        //testPretenureSize();
        //testTenuringThreshold();
    }

    /**
     * 堆内存20M，年轻代10M （Eden 8M Survivor 1M *2）,老年代 10M
     * -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *
     *
     * UseSerialGC时会触发MonitorGC，因survor空间不足进入老年代，再分配4M
     *
     * */
    private static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * int_1MB];
        allocation2 = new byte[2 * int_1MB];
        allocation3 = new byte[2 * int_1MB];
        allocation4 = new byte[4 * int_1MB];
    }

    /**
     * 堆内存20M，年轻代10M （Eden 8M Survivor 1M *2）,老年代 10M
     * -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * */
    private static void testPretenureSize(){
        byte[] allocation4;
        allocation4 = new byte[4 * int_1MB];
    }

    /**
     * 堆内存20M，年轻代10M （Eden 8M Survivor 1M *2）,老年代 10M
     * -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1  ？？？
     * -XX:+PrintTenuringDistribution
     * */
    private static void testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[int_1MB / 4];
        allocation2 = new byte[4 * int_1MB];
        allocation3 = new byte[4 * int_1MB];
        allocation3 = null;
        allocation3 = new byte[4 * int_1MB];
    }
}
