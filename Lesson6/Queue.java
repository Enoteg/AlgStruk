package Lesson6;

public class Queue implements InterfaceQueue {
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
        if (nItems == maxSize) System.out.println("Приоритетная очередь переполнена");
        else {
            int j;// сдвинуть вверх

            if (nItems == 0) { // Если очередь пуста,
                queArray[nItems++] = item; // вставляем в ячейку 0
            }
            else { // Если очередь содержит элементы
                for (j = nItems - 1; j >= 0; j--) { // Перебор в обратном направлении
                    if (item > queArray[j]) { // Если новый элемент больше,
                        queArray[j + 1] = queArray[j]; // сдвинуть вверх
                    } else { // Если меньше,
                        break; // сдвиг прекращается
                    }
                }
                queArray[j + 1] = item; // Вставка элемента
                nItems++;
            }
        }
    }

    public long remove() { // Извлечение элемента в начале очереди
        long temp = queArray[front++]; // Выборка и увеличение front
        if (front == maxSize) { // Циклический перенос
            front = 0;
        }
        nItems--; // Уменьшение количества элементов
        return temp;
    }

    public long peekFront() { // Чтение элемента в начале очереди
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
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }
}

