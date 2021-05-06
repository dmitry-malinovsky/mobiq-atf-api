package com.mobiq.test.utils.dataGeneration.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface GenerateCollection {
    GenerateValue valueGenerator();

    int count() default 1;
}
