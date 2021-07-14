package com.syncretis.util;

import com.syncretis.annotation.FieldName;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Parser <T> {


    public Map<String, String> parseObjectToMap( T object) throws IllegalAccessException {
        Map<String, String> fielder = new HashMap<>();

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fildValue = field.get(object);
            FieldName fieldName  =  field.getDeclaredAnnotation(FieldName.class);

            if(!Objects.isNull(fieldName)) {
                fielder.put(fieldName.name(), String.valueOf(fildValue));
            } else {
                fielder.put(field.getName(), String.valueOf(fildValue));
            }
        }
        return fielder;
    }

    public T perseMapToObject(Map<String, String> stringFields, T type) throws IllegalAccessException {
        T instance = new Object<T>();
        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            FieldName annotation = field.getDeclaredAnnotation(FieldName.class);

            if (!Objects.isNull(annotation)) {
                if(stringFields.containsKey(annotation.name())) {
                    field.set(instance, stringFields.get(annotation.name()));
                } else {
                    field.set(instance, stringFields.get(field.getName()));
                }
            } else {
                field.set(instance, stringFields.get(field.getName()));
            }
        }
        return instance;
    }
}
