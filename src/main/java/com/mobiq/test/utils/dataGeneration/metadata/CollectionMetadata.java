package com.mobiq.test.utils.dataGeneration.metadata;

import com.mobiq.test.utils.dataGeneration.annotation.GenerateCollection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public class CollectionMetadata extends Metadata {
    private Type fieldType;
    private int collectionSize;

    public CollectionMetadata(Field field) {
        super(field.isAnnotationPresent(GenerateCollection.class) ? ((GenerateCollection) field.getDeclaredAnnotation(GenerateCollection.class)).valueGenerator().value() : null, field.getType());
        this.fieldType = field.getGenericType();
        this.collectionSize = field.isAnnotationPresent(GenerateCollection.class) ? ((GenerateCollection) field.getDeclaredAnnotation(GenerateCollection.class)).count() : 1;
    }

    public Optional<ParameterizedType> getParameterizedType() {
        if (this.fieldType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) this.fieldType;
            return Optional.of(parameterizedType);
        } else {
            return Optional.empty();
        }
    }

    public Type getFieldType() {
        return this.fieldType;
    }

    public int getCollectionSize() {
        return this.collectionSize;
    }
}
