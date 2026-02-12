package com.example.endtermesportsirtay_aldiyar.cache;

public interface CacheManager {

    void put(String key, Object value);
    Object get(String key);
    void remove(String key);
    void clear();
    boolean contains(String key);
}
