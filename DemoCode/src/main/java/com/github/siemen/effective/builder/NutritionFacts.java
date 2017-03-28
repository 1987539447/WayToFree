package com.github.siemen.effective.builder;

/**
 * Created by Zhan on 2017/3/22 0022.
 */
public class NutritionFacts {
    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbonhydrate;

    public static NBuilder newBuilder(int servingSize,int serving){
        return new NBuilder(servingSize,serving);
    }

    public static class NBuilder implements Builder<NutritionFacts> {

        private final int servingSize;
        private final int serving;

        private  int calories = 0;
        private  int fat = 0;
        private  int sodium = 0;
        private  int carbonhydrate = 0;


        public NBuilder(int servingSize,int serving){
            this.servingSize = servingSize;
            this.serving = serving;
        }

        public NBuilder calories(int val){
            this.calories = val;
            return  this;
        }

        public NBuilder fat(int val){
            this.fat = val;
            return  this;
        }

        public NBuilder sodium(int val){
            this.sodium = val;
            return  this;
        }

        public NBuilder carbonhydrate(int val){
            this.carbonhydrate = val;
            return  this;
        }

        @Override
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(NBuilder builder){
        servingSize = builder.servingSize;
        serving = builder.serving;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbonhydrate = builder.carbonhydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", serving=" + serving +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbonhydrate=" + carbonhydrate +
                '}';
    }
}
