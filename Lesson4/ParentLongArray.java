package Lesson4;

public abstract class ParentLongArray implements Interface {
    final long[] array;
    int nElems;
    long minValue;
    long maxValue;

    public ParentLongArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
        this.minValue = Long.MAX_VALUE;
        this.maxValue = Long.MIN_VALUE;
    }

    @Override
    public boolean contains(long searchValue) {
        int lower = 0;
        int upper = nElems - 1;

        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (array[mid] == searchValue) {
                return true;
            } else if (array[mid] < searchValue) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return false;
    }

    @Override
    public boolean insert(long value) {
        if (nElems == 0) {
            minValue = value;
            maxValue = value;
            array[nElems++] = value;
            return true;
        }

        if (value < minValue) {
            minValue = value;
        }
        if (value > maxValue) {
            maxValue = value;
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

        return true;
    }

    @Override
    public long getMax() {
        return maxValue;
    }

    @Override
    public long getMin() {
        return minValue;
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
        } else {
            if (value == minValue || value == maxValue) {
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
        }

        return true;
    }

    @Override
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {

        return this.nElems;
    }
}
