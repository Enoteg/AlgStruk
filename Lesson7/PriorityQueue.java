package Lesson7;

public class PriorityQueue {
    private Link<Integer> front;
    private int size;
    private int maxSize;

    public PriorityQueue(int size) {
        front = null;
        this.size = 0;
        this.maxSize = size;
    }

    public void insert(Integer item) {
        if (isFull()) {
            System.out.println("Ошибка: Очередь переполнена!");
            return;
        }

        Link<Integer> newLink = new Link<>(item);
        if (isEmpty()) {
            front = newLink;
        } else {
            Link<Integer> current = front;
            Link<Integer> previous = null;

            while (current != null && item.compareTo(current.getData()) <= 0) {
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


    public Integer remove() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return null;
        }
        Integer data = front.getData();
        front = front.getNext();
        size--;
        return data;
    }

    public Integer peekFront() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return null;
        }
        return front.getData();
    }

    public Integer peekMin() {
        if (isEmpty()) {
            System.out.println("Ошибка: Приоритетная очередь пуста!");
            return null;
        }
        Link<Integer> current = front;
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
            Link<Integer> current = front;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        return size >= maxSize;
    }
}
