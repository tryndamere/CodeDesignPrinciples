package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsMinusFullRule extends ABaseRule {

    private BigDecimal totalAmount;

    public GoodsMinusFullRule(List<Goods> goodsList) {
        this.totalAmount = goodsList.stream().map(Goods::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal discount() {
        return super.discount();
    }

    @Override
    public List<IRule> getIRules() {
        List<IRule> minusFullRules = new ArrayList<>(2);
        minusFullRules.add(new MinusFullRule(new BigDecimal(50), new BigDecimal(100), new BigDecimal(5), totalAmount));
        minusFullRules.add(new MinusFullRule(new BigDecimal(100), new BigDecimal(15), totalAmount));
        return minusFullRules;
    }

    @Override
    public BigDecimal getAmount() {
        return this.totalAmount;
    }
}
