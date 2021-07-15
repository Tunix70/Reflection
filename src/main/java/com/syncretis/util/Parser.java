package com.syncretis.util;

import com.syncretis.annotation.FieldName;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
            FieldName annotationdName  =  field.getDeclaredAnnotation(FieldName.class);

            if(!Objects.isNull(annotationdName)) {
                fielder.put(annotationdName.name(), String.valueOf(fildValue));
            } else {
                fielder.put(field.getName(), String.valueOf(fildValue));
            }
        }
        return fielder;
    }

    public <T> T perseMapToObject(Map<String, String> stringFields, Class<T> type) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Constructor<T> constructor = type.getConstructor();
        T instance = constructor.newInstance();

        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            FieldName annotation = field.getDeclaredAnnotation(FieldName.class);

            if (!Objects.isNull(annotation)) {
                    setStringFieldToInstance(field, stringFields.get(annotation.name()), instance);
            } else {
                setStringFieldToInstance(field, stringFields.get(field.getName()), instance);
            }
        }
        return instance;
    }

    public void setStringFieldToInstance(Field field, String fieldValue, Object instance) throws IllegalAccessException {
        if(!(field.getType() == String.class)){
            Object objValue = parseTypeFromString(field.getType(), fieldValue);
            field.set(instance, objValue);
        } else{
            field.set(instance, fieldValue);
        }
    }

    public Object parseTypeFromString(Class clazz, String value){
        if(Boolean.class == clazz ) {
            return Boolean.parseBoolean(value);
        }
        if(Integer.class == clazz || Integer.TYPE == clazz) {
            return Integer.parseInt(value);
        }
        if(Long.class == clazz) {
            return Long.parseLong(value);
        }
        if(Double.class == clazz) {
            return Double.parseDouble(value);
        }
        return value;
    }
}
