package com.jiker.unit4;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AmountCalculatorTest {

    @Test
    public void should_() {
        AmountCalculator amountCalculator = new AmountCalculator(
                Lists.newArrayList(new Drink("wine", new BigDecimal(15), 1),
                        new Drink("cola", new BigDecimal(5), 2),
                        new Meat("pork", new BigDecimal(25), 2),
                        new Meat("chicken", new BigDecimal(10), 5),
                        new Electronics("light", new BigDecimal(100), 1)));
        System.out.println(amountCalculator.checkOut().doubleValue());
    }
}
