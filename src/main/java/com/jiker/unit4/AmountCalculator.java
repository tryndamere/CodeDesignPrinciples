package com.jiker.unit4;

import java.math.BigDecimal;

public class AmountCalculator {

    private Ruler ruler;

    public AmountCalculator(Ruler ruler) {
        this.ruler = ruler;
    }

    public BigDecimal checkOut() {
        return this.ruler.getTotalAmount().subtract(this.ruler.discount());
    }

}
