package com.example.endtermesportsirtay_aldiyar.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void printFields(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Fields of " + clazz.getSimpleName() + ":");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " = " + field.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access field: " + field.getName());
            }
        }
    }

    public static void printMethods(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Methods of " + clazz.getSimpleName() + ":");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName() + "()");
        }
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Cannot get field value: " + fieldName, e);
        }
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Cannot set field value: " + fieldName, e);
        }
    }
}
