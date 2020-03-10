package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public abstract class Ruler {

    private List<Goods> goodsList;

    private BigDecimal totalAmount;

    public Ruler(List<Goods> goodsList) {
        this.goodsList = goodsList;
        this.totalAmount = goodsList.stream().map(Goods::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public abstract BigDecimal discount();

}
