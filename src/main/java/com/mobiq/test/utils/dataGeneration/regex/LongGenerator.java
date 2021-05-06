package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.function.Function;

public final class LongGenerator extends RegexGenerator<Long> {
    public LongGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, Long> parser() {
        return Long::parseLong;
    }
}