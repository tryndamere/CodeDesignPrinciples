package com.jiker.unit4;

import java.math.BigDecimal;

public class Electronics extends Goods {

    public Electronics(String name, BigDecimal price, int count) {
        super(name, price, count);
    }

    @Override
    public String category() {
        return "electronics";
    }
}
