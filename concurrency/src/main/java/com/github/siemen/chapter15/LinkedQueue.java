package com.github.siemen.chapter15;
/**
 * Created by Zhan on 2017-06-30.
 */

import java.util.concurrent.atomic.AtomicReference;

/**
 * 非阻塞队列
 */
public class LinkedQueue<E> {

    private final Node<E> dummy = new Node<>(null,null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public void put(E item) {
        Node<E> newNode = new Node<>(item,null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> tailNext = curTail.next.get();
            if(curTail == tail.get()){
                if(tailNext != null){//有其他线程插入了新节点，尝试推进tail
                    tail.compareAndSet(curTail,tailNext);
                }else{
                    if(curTail.next.compareAndSet(null,newNode)){//尝试插入新节点
                        tail.compareAndSet(curTail,newNode);//成功后尝试推进tail,可能被其他线程推进，直接返回
                        return;
                    }
                }
            }

        }
    }




    //队列节点
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        private Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }
}
