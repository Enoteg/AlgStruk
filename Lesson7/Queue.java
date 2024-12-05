package Lesson7;

public class Queue {
    private Link front;
    private Link rear;
    private int size;
    private int maxSize;

    public Queue(int maxSize) {
        front = null;
        rear = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void insert(Integer item) {
        if (isFull()) {
            System.out.println("Ошибка: Очередь переполнена!");
            return;
        }

        Link newLink = new Link(item);
        if (isEmpty()) {
            front = newLink;
        } else {
            rear.setNext(newLink);
        }
        rear = newLink;
        size++;
    }

    public Integer remove() {
        if (isEmpty()) {
            System.out.println("Ошибка: Очередь пуста!");
            return null;
        }
        Integer data = (Integer) front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public Integer peekFront() {
        if (isEmpty()) {
            System.out.println("Ошибка: Очередь пуста!");
            return null;
        }
        return (Integer) front.getData();
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
            Link current = front;
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
