package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class DrinkRateRule extends RateRuler {

    public DrinkRateRule(List<Goods> goodsList) {
        super(goodsList);
    }

    @Override
    public BigDecimal discount() {
        BigDecimal drinkAmount = this.getGoodsList().stream()
                .filter(goods -> goods instanceof Drink)
                .map(Goods::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return drinkAmount.multiply(this.discountRate);
    }
}
