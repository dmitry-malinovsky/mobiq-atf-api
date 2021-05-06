package com.mobiq.test.utils.dataGeneration.temporal;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.function.Function;

public final class OffsetDateTimeGenerator extends TemporalGenerator<OffsetDateTime> {
    public OffsetDateTimeGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Function<Instant, OffsetDateTime> temporalMapper() {
        return (instant) -> {
            return OffsetDateTime.ofInstant(instant, this.getZoneId());
        };
    }
}