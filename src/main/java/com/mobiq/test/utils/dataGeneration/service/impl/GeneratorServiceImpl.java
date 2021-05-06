package com.mobiq.test.utils.dataGeneration.service.impl;

import com.mobiq.test.utils.dataGeneration.DataGenerator;
import com.mobiq.test.utils.dataGeneration.GeneratorTypeRegistry;
import com.mobiq.test.utils.dataGeneration.ObjectGeneratorFactory;
import com.mobiq.test.utils.dataGeneration.service.GeneratorService;

public class GeneratorServiceImpl implements GeneratorService {
    public GeneratorServiceImpl() {

    }

    @Override
    public <T> T generateObject(Class<T> type) {
        DataGenerator<T> objectGenerator = ObjectGeneratorFactory.of(type);
        return objectGenerator.generate();
    }

    @Override
    public <T> T generateFromPattern(Class<T> type, String pattern) {
        DataGenerator<?> objectGenerator = GeneratorTypeRegistry.getGenerator(type, pattern);
        return (T) objectGenerator.generate();
    }

    @Override
    public <T> T enrichObject(T object) {
        return ObjectGeneratorFactory.enrich(object);
    }
}
