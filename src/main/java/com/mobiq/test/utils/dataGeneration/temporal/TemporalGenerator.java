package com.mobiq.test.utils.dataGeneration.temporal;

import com.joestelmach.natty.Parser;
import com.mobiq.test.utils.dataGeneration.MetadataGenerator;
import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Function;

public abstract class TemporalGenerator<T extends Temporal> extends MetadataGenerator<T> {
    private final Parser nattyParser = new Parser(TimeZone.getTimeZone(this.getZoneId()));

    public TemporalGenerator(Metadata metadata) {
        super(metadata);
    }

    public T generate() {
        return (T) this.generateTimeInstant().map(this.temporalMapper()).orElse((T) null);
    }

    protected ZoneId getZoneId() {
        return ZoneId.of(System.getProperty("config:data-generator.timezone","UTC"));
    }

    protected abstract Function<Instant, T> temporalMapper();

    private Optional<Instant> generateTimeInstant() {
        return this.getMetadata().getPattern().flatMap((s) -> {
            return this.nattyParser.parse(s).stream().flatMap((dateGroup) -> {
                return dateGroup.getDates().stream();
            }).findFirst();
        }).map(Date::toInstant);
    }
}
