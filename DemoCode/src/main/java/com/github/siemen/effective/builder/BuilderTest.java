package com.github.siemen.effective.builder;

/**
 * Created by Zhan on 2017/3/22 0022.
 */
public class BuilderTest {

    public static void main(String[] args) {
        NutritionFacts facts = NutritionFacts.newBuilder(1,2).fat(3).sodium(4).build();
        System.out.println(facts);
    }
}
