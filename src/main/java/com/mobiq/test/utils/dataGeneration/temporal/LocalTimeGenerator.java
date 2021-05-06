package com.mobiq.test.utils.dataGeneration.temporal;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Function;

public final class LocalTimeGenerator extends TemporalGenerator<LocalTime> {
    public LocalTimeGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<Instant, LocalTime> temporalMapper() {
        return (instant) -> {
            return LocalDateTime.ofInstant(instant, this.getZoneId()).toLocalTime();
        };
    }
}