package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 事件处理者实现-贵族
 * 可使用责任链处理多个事件
 */
public class Nobleman extends EventCustomer {

    public Nobleman() {
        super(EventCustomType.EDIT);
        super.addCustomType(EventCustomType.CLONE);
    }

    @Override
    public void exec(ProductEvent event) {
        Product product = event.getSource();
        ProductEventType type = event.getEventType();
        if(type.getValue() == EventCustomType.CLONE.getValue()){
            System.out.println("贵族处理事件："+product.getName()+"克隆，事件类型："+type);
        }else{
            System.out.println("贵族处理事件："+product.getName()+"修改，事件类型："+type);
        }

    }
}
