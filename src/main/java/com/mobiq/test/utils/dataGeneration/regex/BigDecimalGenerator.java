package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;

public final class BigDecimalGenerator extends RegexGenerator<BigDecimal> {
    public BigDecimalGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, BigDecimal> parser() {
        return BigDecimal::new;
    }
}