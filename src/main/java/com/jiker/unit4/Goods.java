package com.jiker.unit4;

import java.math.BigDecimal;

public class Goods {

    private String name;

    private BigDecimal price;

    private int count;

    private Category category;

    public Goods(String name, BigDecimal price, int count, Category category) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }
}
