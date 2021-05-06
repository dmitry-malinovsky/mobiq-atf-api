package com.mobiq.test.utils.dataGeneration.temporal;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;
import com.mobiq.test.utils.dataGeneration.regex.RegexGenerator;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

public final class LocalDateGenerator extends TemporalGenerator<LocalDate> {
    public LocalDateGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<Instant, LocalDate> temporalMapper() {
        return (instant) -> {
            return LocalDateTime.ofInstant(instant, this.getZoneId()).toLocalDate();
        };
    }
}