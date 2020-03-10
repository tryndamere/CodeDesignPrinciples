package com.jiker.unit4;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class AmountCalculatorTest {

    private List<Goods> goodsList = Lists.newArrayList(new Drink("wine", new BigDecimal(15), 1),
            new Drink("cola", new BigDecimal(5), 2),
            new Meat("pork", new BigDecimal(25), 2),
            new Meat("chicken", new BigDecimal(10), 5),
            new Electronics("light", new BigDecimal(100), 1));

    @Test
    public void should_rate_discount_if_amount_180() {
        AmountCalculator amountCalculator = new AmountCalculator(new RateRuler(this.goodsList));
        Assertions.assertEquals(180.0, amountCalculator.checkOut().doubleValue());
    }

    @Test
    public void should_minus_full_discount_if_amount_210() {
        AmountCalculator amountCalculator = new AmountCalculator(new MinusFullRuler(this.goodsList));
        Assertions.assertEquals(210.0, amountCalculator.checkOut().doubleValue());
    }

    @Test
    public void should_drink_rate_discount_if_amount_220() {
        AmountCalculator amountCalculator = new AmountCalculator(new DrinkRateRule(this.goodsList));
        Assertions.assertEquals(220.0, amountCalculator.checkOut().doubleValue());
    }
}
