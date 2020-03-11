package com.jiker.unit4;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

public abstract class ABaseRule implements IRule {

    protected List<IRule> getIRules() {
        return Lists.newArrayList(new RateRule(new BigDecimal(0.8), this.getAmount()));
    }

    protected abstract BigDecimal getAmount();

    public BigDecimal discount() {
        return this.getIRules().stream()
                .map(rule -> rule.discount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
