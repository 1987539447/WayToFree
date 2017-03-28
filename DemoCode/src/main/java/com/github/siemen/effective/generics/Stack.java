package com.github.siemen.effective.generics;
/**
 * Created by Zhan on 2017-03-28.
 */

import java.util.*;

/**
 * 泛型堆栈
 */
public class Stack<E> {
    private E[] elements;
    private int size  = 0;
    private static final int DEFAULT_INIT_CAPCITY = 16;

    public Stack(){
        elements = (E[])new Object[DEFAULT_INIT_CAPCITY];
    }

    public void push(E e){
        ensureCaptity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public void pushAll(Iterable<? extends  E> src){
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> dest){
        while(!isEmpty()){
            dest.add(pop());
        }
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list){

        Iterator<? extends T> it = list.iterator();
        T result = it.next();
        while (it.hasNext()){
            T t = it.next();
            if(t.compareTo(result) > 0){
                result = t;
            }
        }
        return result;
    }

    public void swap(List<?> list,int i,int j){
        swapHelper(list,i,j);
    }
    private <E> void swapHelper(List<E> list,int i,int j){
        list.set(i,list.set(j,list.get(i)));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCaptity() {
    }

}
