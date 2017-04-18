package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */

/**
 * 事件触发
 * 混编模式：观察者模式-中介者模式-工厂方法模式-责任链模式
 */
public class OnFire {
    public static void main(String[] args) {

        EventDispatch dispatch = EventDispatch.getDispatch();
        dispatch.registeCustomer(new Beggar());
        dispatch.registeCustomer(new Commoner());
        dispatch.registeCustomer(new Nobleman());

        ProductManager factory = new ProductManager();

        System.out.println("-----------模拟产品创建事件-------");
        System.out.println("---------创建叫小男孩的原子弹---------");
        Product product = factory.createProduct("小男孩原子弹");

        System.out.println("-----------模拟产品修改事件-------");
        System.out.println("---------修改小男孩原子弹为胖子原子弹---------");
        factory.editProduct(product,"胖子");

        System.out.println("-----------模拟产品克隆事件-------");
        System.out.println("---------克隆胖子原子弹---------");
        factory.clone(product);

        System.out.println("-----------模拟产品销毁事件-------");
        System.out.println("---------销毁胖子原子弹---------");
        factory.abandonProduct(product);

    }
}
