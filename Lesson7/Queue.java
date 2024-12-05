package Lesson7;

public class Queue<T> implements QueueImpl<T> {
    private Link<T> front;
    private Link<T> rear;
    private int size;
    private int maxSize;

    public Queue(int size) {
        front = null;
        rear = null;
        this.size = 0;
    }


    public void insert(T item) {
        Link<T> newLink = new Link<>(item);
        if (isEmpty()) {
            front = newLink;
        } else {
            rear.setNext(newLink);
        }
        rear = newLink;
        size++;
    }


    public T remove() {
        if (isEmpty()) {
            System.out.println("Ошибка: Очередь пуста!");
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }


    public T peekFront() {
        if (isEmpty()) {
            System.out.println("Ошибка: Очередь пуста!");
            return null;
        }
        return front.getData();
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void display() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
        } else {;
            Link<T> current = front;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
            System.out.println();
        }
    }
    public boolean isFull() {
        return size > maxSize;
    }
}
