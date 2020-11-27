package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator compare;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        compare = cmp;
    }

    private Object[] getSortedArr() {
        Object[] returnValue = smartArray.toArray();
        for (int i = 0; i < returnValue.length; i++) {
            for (int j = i + 1; j < returnValue.length; j++) {
                if (compare.compare(returnValue[i], returnValue[j]) > 0) {
                    Object tmp = returnValue[j];
                    returnValue[j] = returnValue[i];
                    returnValue[i] = tmp;
                }
            }
        }
        return returnValue;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(getSortedArr(), size());
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}