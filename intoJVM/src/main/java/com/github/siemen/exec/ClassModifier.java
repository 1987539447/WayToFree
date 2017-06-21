package com.github.siemen.exec;
/**
 * Created by Zhan on 2017-05-12.
 */

/**
 * 修改Class字节码文件 修改常量池常量
 */
public class ClassModifier {

    /**class文件中常量池起始偏移*/
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**CONSTANT_Utf8_info 常量的tag标志*/
    private static final int CONSTANT_Utf8_info = 1;

    /**常量池中11种常量所占长度*/
    private static final int[] CONSTATN_ITEM_LENGTH = {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte){
        this.classByte = classByte;
    }

    public byte[] modifyUtf8Constant(String oldStr,String newStr){
        return null;
    }
}
