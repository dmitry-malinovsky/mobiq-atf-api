package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.math.BigInteger;
import java.util.function.Function;

public final class BigIntegerGenerator extends RegexGenerator<BigInteger> {
    public BigIntegerGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, BigInteger> parser() {
        return BigInteger::new;
    }
}