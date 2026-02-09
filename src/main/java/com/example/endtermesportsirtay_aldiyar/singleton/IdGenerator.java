package com.example.endtermesportsirtay_aldiyar.singleton;

public class IdGenerator {

    private static IdGenerator instance;
    private int counter = 1;

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public int nextId() {
        return counter++;
    }
}
