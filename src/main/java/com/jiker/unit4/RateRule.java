package com.jiker.unit4;

import java.math.BigDecimal;

public class RateRule implements IRule {

    private BigDecimal discountRate;

    private BigDecimal amount;


    public RateRule(BigDecimal discountRate, BigDecimal amount) {
        this.discountRate = discountRate;
        this.amount = amount;
    }

    @Override
    public BigDecimal discount() {
        return this.amount.multiply((BigDecimal.ONE.subtract(discountRate)));
    }

}
