package com.mobiq.test.utils.dataGeneration.map;

import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LinkedHashMapGenerator extends MapGenerator {

    public LinkedHashMapGenerator(Metadata metadata) {
        super(metadata);
    }

    protected <T1, T2> Supplier<Map<T1, T2>> collectionSupplier() {
        return LinkedHashMap::new;
    }
}
