package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

import java.util.List;

/**
 * 奔驰建造者实现
 */
public class BenzBuilder extends CarBuilder {
    @Override
    public CarModel getCarModel(List<String> sequnce) {
        CarModel carModel = new BenzModel();
        carModel.setSequence(sequnce);
        return carModel;
    }
}
