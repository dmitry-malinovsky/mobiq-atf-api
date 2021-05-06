package com.mobiq.test.utils.dataGeneration.map;

import com.mobiq.test.utils.dataGeneration.DataGenerator;
import com.mobiq.test.utils.dataGeneration.GeneratorTypeRegistry;
import com.mobiq.test.utils.dataGeneration.MetadataGenerator;
import com.mobiq.test.utils.dataGeneration.metadata.MapMetadata;
import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.util.Map;
import java.util.function.Supplier;

public abstract class MapGenerator extends MetadataGenerator<Map> {
    private MapMetadata mapMetadata;

    public MapGenerator(Metadata metadata) {
        super(metadata);
        if (metadata instanceof MapMetadata) {
            this.mapMetadata = (MapMetadata) metadata;
        }
    }

    public Map generate() {
        Map result = (Map) this.collectionSupplier().get();
        if (this.mapMetadata.keyAndValueClassesDefined()) {
            DataGenerator<?> keyGenerator = this.getGenerator(this.mapMetadata.getKeyMetadata());
            DataGenerator<?> valueGenerator = this.getGenerator(this.mapMetadata.getValueMetadata());

            for (int i = 0; i < this.mapMetadata.getCollectionSize(); i++) {
                result.put(keyGenerator.generate(), valueGenerator.generate());
            }
        }

        return result;
    }

    protected abstract <T1, T2> Supplier<Map<T1, T2>> collectionSupplier();

    private DataGenerator<?> getGenerator(Metadata metadata) {
        return GeneratorTypeRegistry.getGenerator(metadata.getType(), (String)metadata.getPattern().orElse((String) null));
    }
}
