package com.mobiq.test.utils.dataGeneration.regex;

import com.mobiq.test.utils.dataGeneration.DataGenerator;
import com.mobiq.test.utils.dataGeneration.MetadataGenerator;
import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.Optional;
import java.util.function.Function;

public abstract class RegexGenerator<T> extends MetadataGenerator<T> {
    protected static final DataGenerator<String> nullGenerator = () -> {
        return null;
    };

    public RegexGenerator(Metadata metadata) {
        super(metadata);
    }

    public T generate() {
        DataGenerator<String> regexDataGenerator = (DataGenerator) this.getMetadata().getPattern().map(RegexGeneratorFactory::getGenerator).orElse(nullGenerator);
        String rawValue = (String) regexDataGenerator.generate();
        return rawValue != null? this.parse(rawValue) : this.defaultValue();
    }

    private T parse(String raw){
        return Optional.ofNullable(this.parser()).map((typeParser) -> {
            return typeParser.apply(raw);
        }).orElse(this.defaultValue());
    }

    protected T defaultValue(){
        return null;
    }

    protected abstract Function <String, T> parser();
}
