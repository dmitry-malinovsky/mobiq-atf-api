package com.mobiq.test.utils.dataGeneration;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtils {

    public static Object getFieldValue(Field field, Object object) {
        if (object != null && field != null) {
            Object var2;
            try {
                field.setAccessible(true);
                var2 = field.get(object);
            } catch (IllegalAccessException var6) {
                throw new RuntimeException("Could not retrieve field value ", var6);
            } finally {
                field.setAccessible(false);
            }
            return var2;
        } else {
            throw new IllegalArgumentException("Could not get instance field value: null instance ?");
        }
    }

    public static <T> void setFieldValue(T instance, Field field, T value) {
        if (instance != null && field != null) {
            try {
                field.setAccessible(true);
                field.set(instance, value);
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        } else {
            throw new IllegalArgumentException("Could not set instance field value: null instance ?");
        }
    }

    public static List<Field> getAllFieldsWithInherited(Class<?> type) {
        List<Field> fields = new ArrayList<>();
        for (Class c = type; c != null; c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
}
