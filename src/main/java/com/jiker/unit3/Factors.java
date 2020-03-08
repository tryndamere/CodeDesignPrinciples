package com.jiker.unit3;

public class Factors {

    private double baseFactor;

    private double weightFactor;

    private double inchesFactor;

    private double ageFactor;

    public Factors(double baseFactor, double weightFactor, double inchesFactor, double ageFactor) {
        this.baseFactor = baseFactor;
        this.weightFactor = weightFactor;
        this.inchesFactor = inchesFactor;
        this.ageFactor = ageFactor;
    }

    public double getBaseFactor() {
        return baseFactor;
    }

    public double getWeightFactor() {
        return weightFactor;
    }

    public double getInchesFactor() {
        return inchesFactor;
    }

    public double getAgeFactor() {
        return ageFactor;
    }
}
