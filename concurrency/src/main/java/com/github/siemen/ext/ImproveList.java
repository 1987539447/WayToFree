package com.github.siemen.ext;
/**
 * Created by Zhan on 2017-06-21.
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 通过组合实现缺少即加入
 * 实现List接口，但把具体实现委托给底层list对应操作
 * 在本类中引入新的锁层，不关心底层list是否使用锁
 * 存在双重加锁，有一定性能损失
 */
public class ImproveList<T> implements List<T> {

    private final List<T> list;

    public ImproveList(List<T> list) {
        this.list = list;
    }

    /**使用内部锁加锁实现缺少即加入*/
    public synchronized boolean putIfAbsent(T t) {
        boolean absent = !this.list.contains(t);
        if(absent){
            this.list.add(t);
        }
        return  absent;
    }


    /**加内部锁，具体实现调用底层list*/
    @Override
    public synchronized int size() {
        return this.list.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
