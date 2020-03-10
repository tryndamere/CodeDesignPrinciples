package com.jiker.unit4;

import java.math.BigDecimal;

public class Drink extends Goods {

    public Drink(String name, BigDecimal price, int count) {
        super(name, price, count);
    }

    @Override
    public String category() {
        return "Drink";
    }


}
