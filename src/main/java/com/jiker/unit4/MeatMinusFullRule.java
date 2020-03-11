package com.jiker.unit4;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MeatMinusFullRule extends ABaseRule implements IRule {

    private BigDecimal totalAmount;

    public MeatMinusFullRule(List<Goods> goodsList) {
        this.totalAmount = goodsList.stream()
                .filter(goods -> Category.MEAT.name().equalsIgnoreCase(goods.getCategory().name()))
                .map(Goods::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public MeatMinusFullRule(List<Goods> goodsList, String excludeName) {
        if (StringUtils.isEmpty(excludeName)) {
            throw new NullPointerException("排除对象不能为空！");
        }
        this.totalAmount = goodsList.stream()
                .filter(goods -> Category.MEAT.name().equalsIgnoreCase(goods.getCategory().name()))
                .filter(goods -> !excludeName.equalsIgnoreCase(goods.getName()))
                .map(Goods::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal discount() {
        return this.getDiscount();
    }

    @Override
    public List<IRule> getIRules() {
        List<IRule> minusFullRules = new ArrayList<>(2);
        minusFullRules.add(new MinusFullRule(new BigDecimal(20), new BigDecimal(60), new BigDecimal(2), totalAmount));
        minusFullRules.add(new MinusFullRule(new BigDecimal(60), new BigDecimal(8), totalAmount));
        return minusFullRules;
    }

    @Override
    public BigDecimal getAmount() {
        return this.totalAmount;
    }
}
