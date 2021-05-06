package com.mobiq.test.utils.dataGeneration.regex;

import com.mifmif.common.regex.Generex;
import com.mobiq.test.utils.dataGeneration.DataGenerator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegexGeneratorFactory {
    public static final Map<String, Generex> generexCache = new ConcurrentHashMap();

    public static DataGenerator<String> getGenerator(String regex) {
        Generex generex = (Generex) generexCache.computeIfAbsent(regex, Generex::new);
        return generex::random;
    }

    private RegexGeneratorFactory() {
    }
}
