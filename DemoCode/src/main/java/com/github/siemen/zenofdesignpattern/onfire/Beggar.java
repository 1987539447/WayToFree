package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 事件处理者实现-乞丐
 */
public class Beggar extends EventCustomer {

    public Beggar() {
        super(EventCustomType.DEL);
    }

    @Override
    public void exec(ProductEvent event) {
        Product product = event.getSource();
        ProductEventType type = event.getEventType();
        System.out.println("乞丐处理事件："+product.getName()+"销毁，事件类型："+type);
    }
}
