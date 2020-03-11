package com.jiker.unit4;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class AmountCalculatorTest {

    private List<Goods> goodsList;

    private BigDecimal amount;

    public AmountCalculatorTest() {
        this.goodsList = Lists.newArrayList(new Goods("wine", new BigDecimal(15), 1, Category.DRINK),
                new Goods("cola", new BigDecimal(5), 2, Category.DRINK),
                new Goods("pork", new BigDecimal(25), 2, Category.MEAT),
                new Goods("chicken", new BigDecimal(10), 5, Category.MEAT),
                new Goods("light", new BigDecimal(100), 1, Category.ELECTRONICS));
        this.amount = this.goodsList.stream().map(Goods::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Test
    public void should_rate_discount_if_amount_180() {
        AmountCalculator amountCalculator = new AmountCalculator(Lists.newArrayList(new GoodsRateRule(this.goodsList)), this.amount);
        Assertions.assertEquals(180.0, amountCalculator.checkOut().doubleValue());
    }

    @Test
    public void should_minus_full_discount_if_amount_210() {
        AmountCalculator amountCalculator = new AmountCalculator(Lists.newArrayList(new GoodsMinusFullRule(this.goodsList)), this.amount);
        Assertions.assertEquals(210.0, amountCalculator.checkOut().doubleValue());
    }

    @Test
    public void should_drink_rate_discount_if_amount_220() {
        AmountCalculator amountCalculator = new AmountCalculator(Lists.newArrayList(new DrinkRateRule(this.goodsList)), this.amount);
        Assertions.assertEquals(220.0, amountCalculator.checkOut().doubleValue());
    }

    @Test
    public void should_drink_meat_discount_if_amount_212() {
        AmountCalculator amountCalculator = new AmountCalculator(Lists.newArrayList(new DrinkRateRule(this.goodsList), new MeatMinusFullRule(this.goodsList)), this.amount);
        Assertions.assertEquals(212.0, amountCalculator.checkOut().doubleValue());
    }

    @Test
    public void should_drink_meat_exclude_pork_discount_if_amount_218() {
        AmountCalculator amountCalculator = new AmountCalculator(Lists.newArrayList(new DrinkRateRule(this.goodsList), new MeatMinusFullRule(this.goodsList, "pork")), this.amount);
        Assertions.assertEquals(218.0, amountCalculator.checkOut().doubleValue());
    }
}
