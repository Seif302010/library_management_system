package com.lms.library_management_system.helpers;

import java.lang.reflect.Field;

public class ObjectMapper {

    public static <T, U> void mapNonNullAndNonEmptyValues(T source, U target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);
            try {
                Object value = sourceField.get(source);
                if (value != null && !(value instanceof String && ((String) value).isEmpty())) {
                    for (Field targetField : targetFields) {
                        targetField.setAccessible(true);
                        if (sourceField.getName().equals(targetField.getName()) &&
                                targetField.getType().isAssignableFrom(sourceField.getType())) {
                            targetField.set(target, value);
                            break;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
