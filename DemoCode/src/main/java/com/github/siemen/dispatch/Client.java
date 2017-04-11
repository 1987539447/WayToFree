package com.github.siemen.dispatch;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 方法分派测试类
 * Java为单分派语言
 * 在编译期间对重载行为进行区分决定调用的方法
 * boy.eat(apple) --  People.eat(Fruit)
 * 运行期根据调用者区分--Boy.eat(Fruit)
 */
public class Client {

    public static void main(String[] args) {
        People boy = new Boy();
        Fruit apple = new Apple();
        Banana banana = new Banana();
        boy.eat(apple);
        boy.eat(banana);
    }
}
