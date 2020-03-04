package com.jiker.unit3;

public class FemaleCalories extends Calories {

    public FemaleCalories(Builder builder) {
        super(builder);
        this.baseFactor = 655d;
        this.weightFactor = 4.3d;
        this.inchesFactor = 4.7d;
        this.ageFactor = 4.7d;
    }
}
