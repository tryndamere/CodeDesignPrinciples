package com.jiker.unit4;

import java.math.BigDecimal;
import java.util.List;

public class MinusFullRuler extends Ruler {

    public MinusFullRuler(List<Goods> goodsList) {
        super(goodsList);
    }

    @Override
    public BigDecimal discount() {
        if (isMoreThan50AndLess100()) {
            return new BigDecimal(5);
        }
        if (isMoreThan100()) {
            return new BigDecimal(15);
        }
        return BigDecimal.ZERO;
    }

    private boolean isMoreThan50AndLess100() {
        return this.getTotalAmount().compareTo(new BigDecimal(50)) >= 0
                && this.getTotalAmount().compareTo(new BigDecimal(100)) < 0;
    }

    private boolean isMoreThan100() {
        return this.getTotalAmount().compareTo(new BigDecimal(100)) >= 0;
    }
}
