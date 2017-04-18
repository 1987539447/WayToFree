package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 事件处理者实现-平民
 */
public class Commoner extends EventCustomer {

    public Commoner() {
        super(EventCustomType.NEW);
    }

    @Override
    public void exec(ProductEvent event) {
        Product product = event.getSource();
        ProductEventType type = event.getEventType();
        System.out.println("平民处理事件："+product.getName()+"诞生，事件类型："+type);
    }
}
