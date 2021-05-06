package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.function.Function;

public final class IntegerGenerator extends RegexGenerator<Integer> {
    public IntegerGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, Integer> parser() {
        return Integer::parseInt;
    }
}
