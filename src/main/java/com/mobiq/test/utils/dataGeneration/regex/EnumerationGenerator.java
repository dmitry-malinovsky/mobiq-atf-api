package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.math.BigDecimal;
import java.util.function.Function;

public final class EnumerationGenerator extends RegexGenerator<Enum<?>> {
    public EnumerationGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<String, Enum<?>> parser() {
        Class<Enum> type = (Class<Enum>) this.getMetadata().getType();
        return (s) -> {
            return Enum.valueOf(type, s);
        };
    }
}