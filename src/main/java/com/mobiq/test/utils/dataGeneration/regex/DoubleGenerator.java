package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.function.Function;

public final class DoubleGenerator  extends RegexGenerator<Double> {
    public DoubleGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, Double> parser() {
        return Double::parseDouble;
    }
}