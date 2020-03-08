package com.jiker.unit3;

public enum Gender {

    MALE(new Factors(66d, 6.3d, 12.9d, 6.8d)),
    FEMALE(new Factors(655d, 4.3d, 4.7d, 4.7d)),
    X1(new Factors(44d, 5.3d, 5.7d, 3.7d)),
    X2(new Factors(58d, 3.3d, 7.7d, 8.7d));

    private Factors factors;

    Gender(Factors factors) {
        this.factors = factors;
    }

    public Factors getFactors() {
        return factors;
    }

    public static Factors getFactors(String name) {
        return Gender.valueOf(name.toUpperCase()).getFactors();
    }
}
