package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate predicate;
    private int index;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    private Object[] getFilteredArr() { //Gets a copy of base array without duplications and saves index
        Object[] returnValue = new Object[smartArray.size()];
        Object[] values = smartArray.toArray();
        int index = 0;
        for (Object value: values) {
            if (predicate.test(value)) {
                returnValue[index] = value;
                index++;
            }
        }
        this.index = index;
        return Arrays.copyOf(returnValue, index);
    }

    @Override
    public Object[] toArray() {
        return getFilteredArr();
    }

    @Override
    public String operationDescription() {
        return "Filtering values that don't fit predicate";
    }

    @Override
    public int size() {
        getFilteredArr();
        return index;
    }
}