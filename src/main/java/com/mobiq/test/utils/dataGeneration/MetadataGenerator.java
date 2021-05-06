package com.mobiq.test.utils.dataGeneration;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

public abstract class MetadataGenerator<T> implements DataGenerator<T> {
    private final Metadata metadata;

    public MetadataGenerator(Metadata metadata){
        this.metadata = metadata;
    }

    public Metadata getMetadata(){
        return this.metadata;
    }
}
