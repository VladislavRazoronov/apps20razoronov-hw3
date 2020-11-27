package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction func;
    int index;

    public MapDecorator(SmartArray smartArray, MyFunction
            function) {
        super(smartArray);
        func = function;
    }

    private Object[] getMappedArr() {
        Object[] returnValue = new Object[smartArray.size()];
        Object[] values = smartArray.toArray();
        int index = 0;
        for (Object value: values) {
            returnValue[index] = func.apply(value);
            index++;
        }
        this.index = index;
        return Arrays.copyOf(returnValue, index);
    }

    @Override
    public Object[] toArray() {
        return getMappedArr();
    }

    @Override
    public String operationDescription() {
        return "Applied function to all values";
    }

    @Override
    public int size() {
        getMappedArr();
        return index;
    }
}