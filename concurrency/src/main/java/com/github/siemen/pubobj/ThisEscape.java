package com.github.siemen.pubobj;
/**
 * Created by Zhan on 2017-06-19.
 */

import java.awt.*;
import java.util.EventListener;


/**
 * this指针逸出
 * 匿名内部类EventListener隐式持有外部类的指针
 */
public class ThisEscape {
    private String state = "Y";

    public ThisEscape(EventSource source){
        source.registListener(new EventListener(){
            public void onEvent(Event e){
                state = "N";
                doSomething(e);
            }
        });
    }

    private void doSomething(Event e) {

    }

    private class EventSource {
        public void registListener(EventListener eventListener) {
        }
    }
}
