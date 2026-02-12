package com.example.endtermesportsirtay_aldiyar.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCacheManager implements CacheManager {

    private static InMemoryCacheManager instance;

    private final Map<String, Object> cacheStore;

    private InMemoryCacheManager() {
        cacheStore = new ConcurrentHashMap<>();
    }

    public static synchronized InMemoryCacheManager getInstance() {
        if (instance == null) {
            instance = new InMemoryCacheManager();
        }
        return instance;
    }

    @Override
    public void put(String key, Object value) {
        cacheStore.put(key, value);
    }

    @Override
    public Object get(String key) {
        return cacheStore.get(key);
    }

    @Override
    public void remove(String key) {
        cacheStore.remove(key);
    }

    @Override
    public void clear() {
        cacheStore.clear();
    }

    @Override
    public boolean contains(String key) {
        return cacheStore.containsKey(key);
    }
}
