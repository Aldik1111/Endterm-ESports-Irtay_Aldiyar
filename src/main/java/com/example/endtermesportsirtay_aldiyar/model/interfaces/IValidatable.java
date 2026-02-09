package com.example.endtermesportsirtay_aldiyar.model.interfaces;

public interface IValidatable<T> {

    boolean isValid(T obj);

    default void validateOrThrow(T obj) {
        if (!isValid(obj)) {
            throw new IllegalArgumentException("Validation failed for object: " + obj);
        }
    }

    static void printValidationInfo() {
        System.out.println("Validating domain object...");
    }
}
