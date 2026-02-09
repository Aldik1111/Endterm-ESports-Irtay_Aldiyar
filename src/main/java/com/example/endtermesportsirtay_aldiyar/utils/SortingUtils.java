package com.example.endtermesportsirtay_aldiyar.utils;

import com.example.endtermesportsirtay_aldiyar.model.BaseEntity;

import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    public static <T extends BaseEntity> void sortByName(List<T> list) {
        list.sort(Comparator.comparing(BaseEntity::getName));
    }

    public static <T extends BaseEntity> void sortById(List<T> list) {
        list.sort(Comparator.comparingInt(BaseEntity::getId));
    }

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }
}
