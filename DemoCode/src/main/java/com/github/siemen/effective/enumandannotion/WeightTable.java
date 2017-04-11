package com.github.siemen.effective.enumandannotion;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 计算其他星球物体重量
 */
public class WeightTable {
    public static void main(String[] args) {
        double earthWeith = 1231.1;
        double mass = earthWeith / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %s is %f%n",planet,planet.surfaceWeight(mass));
        }
    }
}
