package com.github.siemen.pubobj;
/**
 * Created by Zhan on 2017-06-19.
 */

import java.awt.*;
import java.util.EventListener;

/**
 * 使用工厂方法防止this逸出
 * 通过工厂方法返回实例，把listener注册隐藏在内部
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        this.listener = new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static SafeListener getInstance(EventSource source){
        SafeListener safeListener = new SafeListener();
        source.registListener(safeListener.listener);
        return safeListener;
    }

    private void doSomething(Event e) {

    }

    private static class EventSource {
        public void registListener(EventListener listener) {

        }
    }
}

