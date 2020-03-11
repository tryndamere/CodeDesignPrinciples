package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class GoodsRateRule extends ABaseRule {

    private BigDecimal amount;

    public GoodsRateRule(List<Goods> goodsList) {
        this.amount =
                goodsList.stream().map(Goods::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    protected BigDecimal getAmount() {
        return this.amount;
    }
}
