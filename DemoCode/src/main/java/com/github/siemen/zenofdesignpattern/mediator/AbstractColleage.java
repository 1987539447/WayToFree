package com.github.siemen.zenofdesignpattern.mediator;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 协同类抽象
 */
public class AbstractColleage {
    protected AbstractMediator mediator;
    public AbstractColleage(AbstractMediator mediator){
        this.mediator = mediator;
    }
}
