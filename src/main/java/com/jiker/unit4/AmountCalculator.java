package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class AmountCalculator {

    private List<IRule> rules;

    private BigDecimal amount;

    public AmountCalculator(List<IRule> rules, BigDecimal amount) {
        this.rules = rules;
        this.amount = amount;
    }

    public BigDecimal checkOut() {
        BigDecimal discountAmount = this.rules.stream()
                .map(rule -> rule.discount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return this.amount.subtract(discountAmount);
    }

}
