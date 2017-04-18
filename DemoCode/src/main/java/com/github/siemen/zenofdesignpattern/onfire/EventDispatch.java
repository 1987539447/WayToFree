package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 事件转发处理类：观察者,事件转发处理中介者
 */
public class EventDispatch implements Observer {

    private static final EventDispatch dispatch = new EventDispatch();

    private List<EventCustomer> customerList = new ArrayList<>();

    private EventDispatch(){};

    public static EventDispatch getDispatch(){
        return dispatch;
    }

    @Override
    public void update(Observable o, Object arg) {
        Product product = (Product) arg;
        ProductEvent event = (ProductEvent) o;
        for (EventCustomer customer : customerList) {
            for (EventCustomType eventCustomType : customer.getCustomTypeList()) {
                if(event.getEventType().getValue() == eventCustomType.getValue()){
                    customer.exec(event);
                }
            }
        }
    }

    public void registeCustomer(EventCustomer customer){
        this.customerList.add(customer);
    }
}
