package com.jiker.unit4;

import java.math.BigDecimal;

public class MinusFullRule implements IRule {

    private BigDecimal startRangeAmount;

    private BigDecimal endRangeAmount;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    public MinusFullRule(BigDecimal startRangeAmount, BigDecimal discountAmount, BigDecimal totalAmount) {
        this.startRangeAmount = startRangeAmount;
        this.discountAmount = discountAmount;
        this.totalAmount = totalAmount;
    }

    public MinusFullRule(BigDecimal startRangeAmount, BigDecimal endRangeAmount,
                         BigDecimal discountAmount, BigDecimal totalAmount) {
        this.startRangeAmount = startRangeAmount;
        this.endRangeAmount = endRangeAmount;
        this.discountAmount = discountAmount;
        this.totalAmount = totalAmount;
    }

    public BigDecimal discount() {
        if (this.isRange() ?
                isMoreThanStartRangeAmountAndLessEndRangeAmount() : isMoreThanStartRangeAmount()) {
            return this.discountAmount;
        }
        return BigDecimal.ZERO;
    }

    private boolean isRange() {
        return endRangeAmount != null;
    }

    private boolean isMoreThanStartRangeAmountAndLessEndRangeAmount() {
        return this.totalAmount.compareTo(startRangeAmount) >= 0
                && this.totalAmount.compareTo(endRangeAmount) < 0;
    }

    private boolean isMoreThanStartRangeAmount() {
        return this.totalAmount.compareTo(startRangeAmount) >= 0;
    }
}
