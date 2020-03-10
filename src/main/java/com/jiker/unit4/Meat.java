package com.jiker.unit4;

import java.math.BigDecimal;

public class Meat extends Goods {

    public Meat(String name, BigDecimal price, int count) {
        super(name, price, count);
    }

    @Override
    public String category() {
        return "meat";
    }

}
