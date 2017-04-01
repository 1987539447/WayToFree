package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

import java.util.ArrayList;

/**
 * 导演类-根据需求调用建造者
 */
public class Director {
    private ArrayList<String> sequnce = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BmwBuilder bmwBuilder = new BmwBuilder();

    public CarModel getBenzModelA(){
        this.sequnce.clear();
        this.sequnce.add("START");
        this.sequnce.add("STOP");
        return benzBuilder.getCarModel(this.sequnce);
    }

    public CarModel getBenzModelB(){
        this.sequnce.clear();
        this.sequnce.add("START");
        this.sequnce.add("ENGINE");
        this.sequnce.add("STOP");
        return benzBuilder.getCarModel(this.sequnce);
    }

    public CarModel getBmwModelA(){
        this.sequnce.clear();
        this.sequnce.add("ALARM");
        this.sequnce.add("START");
        this.sequnce.add("STOP");
        return bmwBuilder.getCarModel(this.sequnce);
    }
}
