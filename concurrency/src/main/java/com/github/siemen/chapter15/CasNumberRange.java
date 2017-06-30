package com.github.siemen.chapter15;
/**
 * Created by Zhan on 2017-06-30.
 */

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 通过CAS避免多元变量约束
 * 满足条件时构建新的IntPaire
 * 然后原子化更新引用，失败则从头重试
 */
public class CasNumberRange {

    private final AtomicReference<IntPair> value = new AtomicReference<>(new IntPair(0,0));
    public int getLower(){
        return value.get().lower;
    }
    public int getUpper(){
        return value.get().upper;
    }

    public void setLower(int i){
        while (true) {
            IntPair oldValue = value.get();
            if(i > oldValue.upper){
                throw new IllegalStateException("Can't set lower to "+i+"> upper");
            }
            IntPair newValue = new IntPair(i,oldValue.upper);
            if(value.compareAndSet(oldValue,newValue)){
                return;
            }
        }
    }


    @Immutable
    private class IntPair {
        private final int lower;
        private final int upper;

        private IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
}
