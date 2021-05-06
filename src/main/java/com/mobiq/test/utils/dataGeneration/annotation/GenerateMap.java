package com.mobiq.test.utils.dataGeneration.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface GenerateMap {
    GenerateValue key() default  @GenerateValue("");
    GenerateValue value() default  @GenerateValue("");

    int count() default 1;
}
