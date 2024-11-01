package Lesson3;

public class OrderedArray extends ParentLongArray {
    public OrderedArray(int size) {
        super(size);
    }

    @Override
    public boolean contains(long searchValue) {
        int operationsNumber = 0;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentIndex;

        while (true) {
            System.out.println("Количество операций в упорядоченном массиве: " + ++operationsNumber);
            currentIndex = (lowerBound + upperBound) / 2;
            long currentElement = array[currentIndex];
            if (currentElement == searchValue) {
                return true;
            } else if (lowerBound > upperBound) {
                return false;
            } else {
                if (currentElement < searchValue) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }

    @Override
    public boolean insert(long value) {
        if (this.contains(value)) {
            return false;
        }

        int lowerBound = 0;
        int upperBound = nElems - 1;
        int insertIndex = nElems;

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            if (array[mid] < value) {
                lowerBound = mid + 1;
            } else {
                insertIndex = mid;
                upperBound = mid - 1;
            }
        }

        System.arraycopy(array, insertIndex, array, insertIndex + 1, nElems - insertIndex);
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
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int deleteIndex = -1;

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            if (array[mid] == value) {
                deleteIndex = mid;
                break;
            } else if (array[mid] < value) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
            }
        }

        if (deleteIndex == -1) {
            return false;
        }

        System.arraycopy(array, deleteIndex + 1, array, deleteIndex, nElems - deleteIndex - 1);
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
