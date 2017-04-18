package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

import java.util.Observable;

/**
 * 产品事件类，被观察者
 */
public class ProductEvent extends Observable {

    private Product source;

    private ProductEventType eventType;

    public ProductEvent(Product product){
        this(product,ProductEventType.NEW_PRODUCT);
    }

    public ProductEvent(Product product, ProductEventType eventType) {
        this.source = product;
        this.eventType = eventType;
        notifyEventDispatch();
    }

    private void notifyEventDispatch() {
        super.addObserver(EventDispatch.getDispatch());
        super.setChanged();
        super.notifyObservers(source);
    }

    public Product getSource() {
        return source;
    }

    public ProductEventType getEventType() {
        return eventType;
    }
}
