package com.github.siemen.zenofdesignpattern.bridge;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 调用类
 */
public class Client {
    public static void main(String[] args) {
        House house = new House();
        System.out.println("----------房地产公司运营--------");
        HouseCorp houseCorp = new HouseCorp(house);
        houseCorp.makeMoney();
        System.out.println("-----------山寨公司运营---------");
        ShanZhaiCorp shanzhai = new ShanZhaiCorp(new IPod());
        shanzhai.makeMoney();
    }
}
