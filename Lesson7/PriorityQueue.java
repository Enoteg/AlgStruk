package Lesson7;

public class PriorityQueue<T> implements QueueImpl<T> {
    private Link<T> front;
    private int size;
    private int maxSize;

    public PriorityQueue(int size) {
        front = null;
        this.size = 0;
    }


    public void insert(T item) {
        Link<T> newLink = new Link<>(item);
        if (isEmpty()) {
            front = newLink;
        } else {
            Link<T> current = front;
            Link<T> previous = null;

            while (current != null && ((Comparable<T>) item).compareTo(current.getData()) <= 0) {
                previous = current;
                current = current.getNext();
            }

            if (previous == null) {
                newLink.setNext(front);
                front = newLink;
            } else {
                previous.setNext(newLink);
                newLink.setNext(current);
            }
        }
        size++;
    }


    public T remove() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        size--;
        return data;
    }


    public T peekFront() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return null;
        }
        return front.getData();
    }

    public T peekMin() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return null;
        }
        Link<T> current = front;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
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
        } else {
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
