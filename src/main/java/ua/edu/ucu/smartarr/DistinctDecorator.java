package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private int index;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }


    private Object[] getCleanedArr() { //Gets a copy of base array without duplications and saves index
        Object[] returnValue = new Object[smartArray.size()];
        Object[] values = smartArray.toArray();
        int index = 0;
        for (Object value: values) {
            boolean check = true;
            for (Object o: returnValue) {
                if (value.equals(o)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                returnValue[index] = value;
                index++;
            }
        }
        this.index = index;
        return Arrays.copyOf(returnValue, index);
    }

    @Override
    public Object[] toArray() {
        return getCleanedArr();
    }

    @Override
    public String operationDescription() {
        return "Removing all repeating values";
    }

    @Override
    public int size() {
        getCleanedArr();
        return index;
    }
}