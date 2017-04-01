package com.github.siemen.zenofdesignpattern.chain;
/**
 * Created by Zhan on 2017-04-01.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 调用类
 */
public class Client {
    public static void main(String[] args) {
        List<IWomen> womens = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            womens.add(new Women(random.nextInt(4),"我要去逛街"));
        }
        womens.stream().forEach(new HandlerChain());
/*        for (IWomen women : womens) {
            HandlerChain.handleMessage(women);
        }*/
    }
}
