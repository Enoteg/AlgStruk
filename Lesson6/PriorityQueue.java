package Lesson6;

public class PriorityQueue implements QueueImpl {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return -1;
        }
        return queArray[--nItems];
    }

    @Override
    public long peekFront() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return -1;
        }
        return queArray[0];
    }

    public long peekMin() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return -1;
        }
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }


    public int size() {
        return nItems;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
        } else {
            for (int i = 0; i < nItems; i++) {
                System.out.print(queArray[i] + " ");
            }
            System.out.println();
        }
    }

}
