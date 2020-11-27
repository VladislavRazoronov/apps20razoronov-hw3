package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] items;

    public BaseArray(Object[] data) {
        items = Arrays.copyOf(data, data.length);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, items.length);
    }

    @Override
    public String operationDescription() {
        return "No operations applied";
    }

    @Override
    public int size() {
        return items.length;
    }
}