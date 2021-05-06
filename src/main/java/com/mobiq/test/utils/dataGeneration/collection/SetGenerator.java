package com.mobiq.test.utils.dataGeneration.collection;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.*;
import java.util.function.Supplier;

public class SetGenerator extends CollectionGenerator<Set<?>> {

    public SetGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Supplier<Collection<Set<?>>> collectionSupplier() {
        return HashSet::new;
    }
}
