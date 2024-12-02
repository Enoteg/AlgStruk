package Lesson6;

public class Queue implements QueueImpl {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long item) {
        if (isFull()) {
            System.out.println("Ошибка: Очередь переполнена!");
        } else {
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
    }

    public long remove() {
        if (isEmpty()) {
            System.out.println("Ошибка: Очередь пуста!");
            return -1;
        }
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        if (isEmpty()) {
            System.out.println("Ошибка: Очередь пуста!");
            return -1;
        }
        return queArray[front];
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
