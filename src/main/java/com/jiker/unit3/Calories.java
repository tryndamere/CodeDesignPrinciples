package com.jiker.unit3;

import java.text.DecimalFormat;

public class Calories {

    private double weight;

    private double feet;

    private double inches;

    private double age;

    private double calcCalories;

    private Factors factors;

    public static class Builder {

        private Factors factors;

        private double weight;

        private double feet;

        private double inches;

        private double age;

        public Builder factors(Factors factors) {
            this.factors = factors;
            return this;
        }

        public Builder weight(String weight) {
            this.weight = Double.valueOf(weight);
            return this;
        }

        public Builder feet(String feet) {
            this.feet = Double.valueOf(feet);
            return this;
        }

        public Builder inches(String inches) {
            this.inches = Double.valueOf(inches);
            return this;
        }

        public Builder age(String age) {
            this.age = Double.valueOf(age);
            return this;
        }

        public Calories build() {
            return new Calories(this);
        }
    }


    protected Calories(Builder builder) {
        this.factors = builder.factors;
        this.weight = builder.weight;
        this.feet = builder.feet;
        this.inches = builder.inches;
        this.age = builder.age;
    }

    public double getWeight() {
        return weight;
    }

    public double getFeet() {
        return feet;
    }

    public double getInches() {
        return inches;
    }

    public double getAge() {
        return age;
    }

    public String calc() {
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        this.calcCalories = this.factors.getBaseFactor()
                + (this.factors.getWeightFactor() * this.getWeight())
                + (this.factors.getInchesFactor() * ((this.getFeet() * 12) + this.getInches()))
                - (this.factors.getAgeFactor() * this.getAge());
        return decimalFormat.format(calcCalories);
    }
}
