package Lesson4;

public class OrderedArray extends ParentLongArray {
    public OrderedArray(int size) {
        super(size);
    }

    @Override
    public boolean contains(long searchValue) {
        int operationsNumber = 0;
        int lower = 0;
        int upper = nElems - 1;
        int currentIndex;

        while (true) {
            System.out.println("Количество операций в упорядоченном массиве: " + ++operationsNumber);
            currentIndex = (lower + upper) / 2;
            long currentElement = array[currentIndex];
            if (currentElement == searchValue) {
                return true;
            } else if (lower > upper) {
                return false;
            } else {
                if (currentElement < searchValue) {
                    lower = currentIndex + 1;
                } else {
                    upper = currentIndex - 1;
                }
            }
        }
    }

    @Override
    public boolean insert(long value) {
        if (this.contains(value)) {
            return false;
        }

        int lower = 0;
        int upper = nElems - 1;
        int insertIndex = nElems;

        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (array[mid] < value) {
                lower = mid + 1;
            } else {
                insertIndex = mid;
                upper = mid - 1;
            }
        }

        for (int i = nElems; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        array[insertIndex] = value;
        nElems++;

        if (value < minValue) {
            minValue = value;
        }
        if (value > maxValue) {
            maxValue = value;
        }

        return true;
    }

    @Override
    public boolean delete(long value) {
        int lower = 0;
        int upper = nElems - 1;
        int deleteIndex = -1;

        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (array[mid] == value) {
                deleteIndex = mid;
                break;
            } else if (array[mid] < value) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        if (deleteIndex == -1) {
            return false;
        }

        for (int i = deleteIndex; i < nElems - 1; i++) {
            array[i] = array[i + 1];
        }

        nElems--;

        if (nElems == 0) {
            minValue = Long.MAX_VALUE;
            maxValue = Long.MIN_VALUE;
        } else if (value == minValue || value == maxValue) {
            minValue = Long.MAX_VALUE;
            maxValue = Long.MIN_VALUE;
            for (int i = 0; i < nElems; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
                if (array[i] > maxValue) {
                    maxValue = array[i];
                }
            }
        }

        return true;
    }

    @Override
    public long getMin() {

        return minValue;
    }

    @Override
    public long getMax() {

        return maxValue;
    }
}
