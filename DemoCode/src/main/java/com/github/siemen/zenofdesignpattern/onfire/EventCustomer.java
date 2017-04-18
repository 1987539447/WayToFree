package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 事件处理者抽象
 */
public abstract class EventCustomer {

    private List<EventCustomType> customTypeList = new ArrayList<>();

    public EventCustomer(EventCustomType customType){
        customTypeList.add(customType);
    }

    public void addCustomType(EventCustomType customType){
        customTypeList.add(customType);
    }

    public List<EventCustomType> getCustomTypeList() {
        return customTypeList;
    }

    public abstract void exec(ProductEvent event);
}
