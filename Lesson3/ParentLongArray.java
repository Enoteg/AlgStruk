package Lesson3;

public abstract class ParentLongArray implements Interface {
    protected final long[] array;
    protected int nElems;
    protected long minValue;
    protected long maxValue;

    public ParentLongArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
        this.minValue = Long.MAX_VALUE;
        this.maxValue = Long.MIN_VALUE;
    }

    @Override
    public boolean contains(long searchValue) {
        int lowerBound = 0;
        int upperBound = nElems - 1;

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            if (array[mid] == searchValue) {
                return true;
            } else if (array[mid] < searchValue) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
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
