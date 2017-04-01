package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

import java.util.List;

/**
 * 宝马建造者实现
 */
public class BmwBuilder extends CarBuilder {
    @Override
    public CarModel getCarModel(List<String> sequnce) {
        CarModel carModel = new BmwModel();
        carModel.setSequence(sequnce);
        return carModel;
    }
}
