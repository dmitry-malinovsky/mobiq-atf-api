package com.mobiq.test.utils.dataGeneration;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.lang.reflect.InvocationTargetException;

public class ObjectGeneratorFactory {
    public static <T> DataGenerator<T> of(Class<T> type) {
        return () -> {
            T instance = getInstance(type);
            generateValueForNullFieldValues(ReflectionUtils.getAllFieldsWithInherited(type), instance);
            return instance;
        };
    }

    private static <T> T getInstance(Class<T> type) {
        try{
            return type.getConstructor().newInstance();
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e){
            try {
                return (T) type.getDeclaredConstructor(String.class);
            } catch (NoSuchMethodException e1){
                throw new GeneratorException("Could not instantiate constructor with String argument", e);
            }
        } catch (Exception e2){
            throw new GeneratorException("Could not instantiate", e2);
        }
    }

    public static <T> T enrich(T instance) {
        List<Field> allClassFields = ReflectionUtils.getAllFieldsWithInherited(instance.getClass());
        allClassFields.stream().filter((field) -> {
            return Objects.nonNull(ReflectionUtils.getFieldValue(field, instance)) && GeneratorTypeRegistry.isUserDefinedType(field.getType());
        }).forEach((field) -> {
            enrich(ReflectionUtils.getFieldValue(field, instance));
        });
        generateValueForNullFieldValues(allClassFields, instance);
        return instance;
    }

    private static Object generateValue(Field field){
        DataGenerator<?> generator = GeneratorTypeRegistry.getGenerator(field);
        return generator.generate();
    }

    private static <T> void generateValueForNullFieldValues(List<Field> allClassFields, T instance) {
        allClassFields.stream().filter((field) -> {
            return Objects.isNull(ReflectionUtils.getFieldValue(field,instance));
        }).forEach((field) -> {
            ReflectionUtils.setFieldValue(instance, field, generateValue(field));
        });
    }

    private ObjectGeneratorFactory(){

    }
}
