package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class DrinkRateRule extends ABaseRule implements IRule {

    private BigDecimal amount;

    public DrinkRateRule(List<Goods> goodsList) {
        this.amount = goodsList.stream()
                .filter(goods -> Category.DRINK.name().equalsIgnoreCase(goods.getCategory().name()))
                .map(Goods::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal discount() {
        return this.getDiscount();
    }

    @Override
    public BigDecimal getAmount() {
        return this.amount;
    }

}
