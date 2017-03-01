package com.github.siemen.interview;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zhan on 2017/2/23 0023.
 * 数据结构
 * 固定长度队列，当像队列添加数据超过队列长度时，自动移除最后数据
 */
public class LimitQueue<E> implements Queue<E> {

    private int limit;

    Queue<E> queue = new LinkedList<E>();

    public LimitQueue(int limit){
        this.limit = limit;
    }

    public boolean offer(E e) {
        if(queue.size()>= limit){
            queue.poll();
        }
        return queue.offer(e);
    }

    public E poll() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

    public int getLimit() {
        return limit;
    }

    public Queue<E> getQueue() {
        return queue;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(Object o) {
        return queue.contains(o);
    }

    public Iterator<E> iterator() {
        return queue.iterator();
    }

    public Object[] toArray() {
        return queue.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return queue.toArray(a);
    }

    public boolean add(E e) {
        return queue.add(e);
    }

    public boolean remove(Object o) {
        return queue.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return queue.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    public void clear() {
        queue.clear();
    }

    public E remove() {
        return queue.remove();
    }


    public E element() {
        return queue.element();
    }

    public E peek() {
        return queue.peek();
    }
}
