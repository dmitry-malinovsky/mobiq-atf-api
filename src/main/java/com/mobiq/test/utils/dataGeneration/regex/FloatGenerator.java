package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.function.Function;

public final class FloatGenerator extends RegexGenerator<Float> {
    public FloatGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, Float> parser() {
        return Float::parseFloat;
    }
}