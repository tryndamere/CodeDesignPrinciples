package com.jiker.unit4;

import java.math.BigDecimal;

public abstract class Goods {

    private String name;

    private BigDecimal price;

    private int count;

    public Goods(String name, BigDecimal price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getAmount() {
        return this.price.multiply(new BigDecimal(this.count));
    }

    public abstract String category();

}
