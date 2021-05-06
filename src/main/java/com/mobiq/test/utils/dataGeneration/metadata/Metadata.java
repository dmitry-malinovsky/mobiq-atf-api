package com.mobiq.test.utils.dataGeneration.metadata;

import java.util.Optional;

public class Metadata {
    private final String pattern;
    private final Class<?> type;

    public Metadata(String pattern, Class<?> type) {
        this.pattern = pattern;
        this.type = type;
    }

    public Optional<String> getPattern() {
        return Optional.ofNullable(this.pattern);
    }

    public Class<?> getType() {
        return this.type;
    }
}
