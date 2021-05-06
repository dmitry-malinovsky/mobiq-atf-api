package com.mobiq.test.utils.dataGeneration;

import com.mobiq.test.utils.dataGeneration.collection.CollectionGenerator;
import com.mobiq.test.utils.dataGeneration.collection.ListGenerator;
import com.mobiq.test.utils.dataGeneration.collection.SetGenerator;
import com.mobiq.test.utils.dataGeneration.generic.UserDefinedGenerator;
import com.mobiq.test.utils.dataGeneration.map.LinkedHashMapGenerator;
import com.mobiq.test.utils.dataGeneration.metadata.AnnotatedMetadata;
import com.mobiq.test.utils.dataGeneration.metadata.CollectionMetadata;
import com.mobiq.test.utils.dataGeneration.metadata.Metadata;
import com.mobiq.test.utils.dataGeneration.metadata.MapMetadata;
import com.mobiq.test.utils.dataGeneration.regex.*;
import com.mobiq.test.utils.dataGeneration.temporal.LocalDateGenerator;
import com.mobiq.test.utils.dataGeneration.temporal.LocalDateTimeGenerator;
import com.mobiq.test.utils.dataGeneration.temporal.LocalTimeGenerator;
import com.mobiq.test.utils.dataGeneration.temporal.OffsetDateTimeGenerator;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class GeneratorTypeRegistry {
    private static final Function<Metadata, DataGenerator> userDefinedGenerator = UserDefinedGenerator::new;
    private static final Function<Metadata, DataGenerator> enumerationGenerator = EnumerationGenerator::new;
    private static final Map<Class, Function<Metadata, DataGenerator>> generatorMap = new ConcurrentHashMap();

    public static <T> DataGenerator<?> getGenerator(Field field) {
        Object metadata;
        if (Collection.class.isAssignableFrom(field.getType())) {
            metadata = new CollectionMetadata(field);
        } else if (Map.class.isAssignableFrom(field.getType())) {
            metadata = new MapMetadata(field);
        } else {
            metadata = new AnnotatedMetadata(field);
        }
        return getGenerator(field.getType(), (Metadata) metadata);
    }

    public static <T> DataGenerator<T> getGenerator(Class<T> type, String pattern) {
        Metadata metadata = new Metadata(pattern, type);
        return getGenerator(type, metadata);
    }

    private static <T> DataGenerator<T> getGenerator(Class<T> type, Metadata metadata) {
        return type.isEnum() ? (DataGenerator) enumerationGenerator.apply(metadata) : (DataGenerator) ((Function) generatorMap.getOrDefault(type, userDefinedGenerator)).apply(metadata);
    }

    public static boolean isUserDefinedType(Class<?> type) {
        return !Collection.class.isAssignableFrom(type) && !type.isEnum() && !generatorMap.containsKey(type);
    }

    private GeneratorTypeRegistry() {

    }

    static {
        generatorMap.put(Integer.class, IntegerGenerator::new);
        generatorMap.put(Float.class, FloatGenerator::new);
        generatorMap.put(Double.class, DoubleGenerator::new);
        generatorMap.put(Long.class, LongGenerator::new);
        generatorMap.put(Boolean.class, BooleanGenerator::new);
        generatorMap.put(String.class, StringGenerator::new);
        generatorMap.put(LocalDate.class, LocalDateGenerator::new);
        generatorMap.put(LocalDateTime.class, LocalDateTimeGenerator::new);
        generatorMap.put(OffsetDateTime.class, OffsetDateTimeGenerator::new);
        generatorMap.put(LocalTime.class, LocalTimeGenerator::new);
        generatorMap.put(Collection.class, ListGenerator::new);
        generatorMap.put(Map.class, LinkedHashMapGenerator::new);
        generatorMap.put(List.class, ListGenerator::new);
        generatorMap.put(Set.class, SetGenerator::new);
        generatorMap.put(BigInteger.class, BigIntegerGenerator::new);
        generatorMap.put(BigDecimal.class, BigDecimalGenerator::new);
    }
}
