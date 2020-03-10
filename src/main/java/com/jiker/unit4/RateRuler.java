package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class RateRuler extends Ruler{

    protected BigDecimal discountRate = new BigDecimal(1 - 0.8);

    public RateRuler(List<Goods> goodsList) {
        super(goodsList);
    }

    @Override
    public BigDecimal discount() {
        return this.getTotalAmount().multiply(discountRate);
    }
}
