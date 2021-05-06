package com.mobiq.test.utils.dataGeneration.metadata;

import com.mobiq.test.utils.dataGeneration.annotation.GenerateValue;

import java.lang.reflect.Field;

public class AnnotatedMetadata extends Metadata{
    public AnnotatedMetadata(Field field){
        super(field.isAnnotationPresent(GenerateValue.class) ? ((GenerateValue)field.getDeclaredAnnotation(GenerateValue.class)).value() : null, field.getType());
    }
}
