package com.mobiq.test.utils.dataGeneration.collection;

import com.mobiq.test.utils.dataGeneration.DataGenerator;
import com.mobiq.test.utils.dataGeneration.GeneratorTypeRegistry;
import com.mobiq.test.utils.dataGeneration.MetadataGenerator;
import com.mobiq.test.utils.dataGeneration.metadata.CollectionMetadata;
import com.mobiq.test.utils.dataGeneration.metadata.Metadata;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class CollectionGenerator<T> extends MetadataGenerator<Collection<T>>  {
    private CollectionMetadata collectionMetadata;

    public CollectionGenerator(Metadata metadata) {
        super(metadata);
        if (metadata instanceof CollectionMetadata) {
            this.collectionMetadata = (CollectionMetadata) metadata;
        }
    }

    public Collection<T> generate() {
        return (Collection)this.getMetadata().getPattern().map((pattern) -> {
            return GeneratorTypeRegistry.getGenerator(this.getParameterType(), pattern);
        }).map(this.getDataGeneratorListFunction()).orElse((Collection<T>) null);
    }

    protected abstract Supplier<Collection<T>> collectionSupplier();

    private Function<DataGenerator<T>, Collection<T>> getDataGeneratorListFunction(){
        return (dataGenerator) ->{
            Collection<T> collection = (Collection)this.collectionSupplier().get();
            for (int i=0; i < this.collectionMetadata.getCollectionSize(); i++){
                collection.add(dataGenerator.generate());
            }
            return collection;
        };
    }


    private Class<T> getParameterType(){
        return (Class)this.collectionMetadata.getParameterizedType().map((parameterizedType) -> {
            return parameterizedType.getActualTypeArguments()[0];
        }).orElse((Type) null);
    }
}
