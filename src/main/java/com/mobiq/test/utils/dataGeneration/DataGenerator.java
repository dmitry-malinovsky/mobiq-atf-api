package com.mobiq.test.utils.dataGeneration;

@FunctionalInterface
public interface DataGenerator<T> {
    T generate();
}
