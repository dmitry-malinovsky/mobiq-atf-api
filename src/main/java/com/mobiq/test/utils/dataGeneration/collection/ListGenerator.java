package com.mobiq.test.utils.dataGeneration.collection;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class ListGenerator extends CollectionGenerator<List<?>> {

    public ListGenerator(Metadata metadata) {
        super(metadata);
    }

    protected Supplier<Collection<List<?>>> collectionSupplier() {
        return ArrayList::new;
    }
}
