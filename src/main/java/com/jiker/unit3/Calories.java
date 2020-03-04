package com.jiker.unit3;

import java.text.DecimalFormat;

public class Calories {

    private boolean isMale;

    private double weight;

    private double feet;

    private double inches;

    private double age;

    private double calcCalories;

    protected double baseFactor;

    protected double weightFactor;

    protected double inchesFactor;

    protected double ageFactor;

    public static class Builder {

        private boolean isMale;

        private double weight;

        private double feet;

        private double inches;

        private double age;

        public Builder isMale(boolean isMale) {
            this.isMale = isMale;
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
            return this.isMale ? new MaleCalories(this) : new FemaleCalories(this);
        }
    }


    protected Calories(Builder builder) {
        this.isMale = builder.isMale;
        this.weight = builder.weight;
        this.feet = builder.feet;
        this.inches = builder.inches;
        this.age = builder.age;
    }

    public boolean isMale() {
        return isMale;
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
        this.calcCalories = this.baseFactor
                + (this.weightFactor * this.getWeight())
                + (this.inchesFactor * ((this.getFeet() * 12) + this.getInches()))
                - (this.ageFactor * this.getAge());
        return decimalFormat.format(calcCalories);
    }
}
