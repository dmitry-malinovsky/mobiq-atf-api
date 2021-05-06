package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.function.Function;

public final class BooleanGenerator extends RegexGenerator<Boolean> {
    public BooleanGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, Boolean> parser() {
        return Boolean::parseBoolean;
    }
}