package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class AmountCalculator {

    private List<Goods> goodsList;

    public AmountCalculator(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public BigDecimal checkOut() {
        BigDecimal amount = goodsList.stream()
                .map(Goods::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return this.discount(amount);
    }

    private BigDecimal discount(BigDecimal amount) {
        return amount.multiply(new BigDecimal(0.8));
    }
}
