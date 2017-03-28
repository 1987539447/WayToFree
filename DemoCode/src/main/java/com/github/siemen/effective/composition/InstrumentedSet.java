package com.github.siemen.effective.composition;


import java.util.Collection;
import java.util.Set;

/**
 * Created by Zhan on 2017/3/24 0024.
 *
 * 组合优先于继承
 * ForwardingSet类转发对底层Set的调用
 * 可提供不同的set来初始化构造，把一个set转化为另一个set,附加增加计数功能
 * 包装一个set在内部
 *
 */
public class InstrumentedSet<E> extends ForwardingSet<E>{

    private int addCount;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return  this.addCount;
    }
}
