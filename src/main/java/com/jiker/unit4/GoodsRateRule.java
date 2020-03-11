package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class GoodsRateRule extends ABaseRule implements IRule {

    private BigDecimal amount;

    public GoodsRateRule(List<Goods> goodsList) {
        this.amount =
                goodsList.stream().map(Goods::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal discount() {
        return super.getDiscount();
    }

    @Override
    protected BigDecimal getAmount() {
        return this.amount;
    }
}
