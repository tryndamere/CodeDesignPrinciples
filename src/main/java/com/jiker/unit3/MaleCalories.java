package com.jiker.unit3;

public class MaleCalories extends Calories {

    public MaleCalories(Builder builder) {
        super(builder);
        this.baseFactor = 66d;
        this.weightFactor = 6.3d;
        this.inchesFactor = 12.9d;
        this.ageFactor = 6.8d;
    }

}
