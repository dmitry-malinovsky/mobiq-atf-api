package com.mobiq.test.utils.dataGeneration.generic;

import com.mobiq.test.utils.dataGeneration.MetadataGenerator;
import com.mobiq.test.utils.dataGeneration.ObjectGeneratorFactory;
import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

public class UserDefinedGenerator extends MetadataGenerator<Object> {
    public UserDefinedGenerator(Metadata metadata) {
        super(metadata);
    }

    public Object generate() {
        return ObjectGeneratorFactory.of(this.getMetadata().getType()).generate();
    }
}
