package com.mobiq.test.utils.dataGeneration.service;

public interface GeneratorService {
    <T> T generateObject(Class<T> type);

    <T> T generateFromPattern(Class<T> type, String pattern);

    <T> T enrichObject(T object);
}
