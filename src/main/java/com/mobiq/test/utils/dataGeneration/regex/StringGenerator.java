package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.function.Function;

public final class StringGenerator extends RegexGenerator<String> {
    public StringGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, String> parser() {
        return (s) -> {
            return s;
        };
    }
}