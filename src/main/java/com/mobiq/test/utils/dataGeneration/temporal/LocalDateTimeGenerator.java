package com.mobiq.test.utils.dataGeneration.temporal;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

public final class LocalDateTimeGenerator extends TemporalGenerator<LocalDateTime> {
    public LocalDateTimeGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<Instant, LocalDateTime> temporalMapper() {
        return (instant) -> {
            return LocalDateTime.ofInstant(instant, this.getZoneId());
        };
    }
}