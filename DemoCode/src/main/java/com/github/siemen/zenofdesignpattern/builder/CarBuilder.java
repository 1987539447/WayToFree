package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */


import java.util.List;

/**
 * 造车builer抽象
 */
public abstract class CarBuilder {
    public abstract CarModel getCarModel(List<String> sequnce);
}
