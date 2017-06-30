package com.github.siemen.chapter15;
/**
 * Created by Zhan on 2017-06-30.
 */

import java.util.concurrent.atomic.AtomicReference;

/**
 * 非阻塞栈-Treiber算法
 * 不阻塞，一直重试
 * push和pop操作在于对top指针引用的原子化更新，失败则重试
 */
public class ConcurrentStack<E> {

    AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E e){
        Node<E> newHead = new Node<>(e);
        Node<E> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        }while (!top.compareAndSet(oldHead,newHead));
    }

    public E pop(){
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = top.get();
            if(oldHead == null){
                return null;
            }
            newHead = oldHead.next;
        }while (!top.compareAndSet(oldHead,newHead));
        return oldHead.e;
    }


    private class Node<E>{

        public Node<E> next;
        public final E e;

        public Node(E e) {
            this.e  = e;
        }
    }
}
