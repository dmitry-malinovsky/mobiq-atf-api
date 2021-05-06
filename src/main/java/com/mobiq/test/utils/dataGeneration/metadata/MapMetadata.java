package com.mobiq.test.utils.dataGeneration.metadata;

import com.mobiq.test.utils.dataGeneration.annotation.GenerateMap;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.stream.Stream;

public class MapMetadata extends Metadata {
    private final Metadata keyMetadata;
    private final Metadata valueMetadata;
    private int collectionSize;

    public MapMetadata(Field field) {
        super((String) null, field.getType());
        Class<?> keyClass = null;
        Class<?> valueClass = null;
        String keyPattern = null;
        String valuePattern = null;
        Type[] typeArgs = ((ParameterizedTypeImpl) field.getGenericType()).getActualTypeArguments();
        if (typeArgs[0] instanceof Class) {
            keyClass = (Class) typeArgs[0];
        }

        if (typeArgs[1] instanceof Class) {
            valueClass = (Class) typeArgs[1];
        }

        if (field.isAnnotationPresent(GenerateMap.class)) {
            GenerateMap generatedMap = (GenerateMap) field.getDeclaredAnnotation(GenerateMap.class);
            if (!generatedMap.key().value().isEmpty()) {
                keyPattern = generatedMap.key().value();
            }
            this.collectionSize = generatedMap.count();
        }

        this.keyMetadata = new Metadata(keyPattern, keyClass);
        this.valueMetadata = new Metadata(valuePattern, valueClass);
    }

    public boolean keyAndValueClassesDefined() {
        return Stream.of(this.keyMetadata.getType(), this.valueMetadata.getType()).allMatch(Objects::nonNull);
    }


    public Metadata getKeyMetadata() {
        return this.keyMetadata;
    }

    public Metadata getValueMetadata() {
        return this.valueMetadata;
    }

    public int getCollectionSize() {
        return this.collectionSize;
    }
}
