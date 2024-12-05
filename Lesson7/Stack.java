package Lesson7;

public class Stack implements StackImpl {
    private Link<Character> top;
    private int size;
    private int maxSize;

    public Stack(int maxSize) {
        this.top = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void push(char j) {
        if (isFull()) {
            System.out.println("Ошибка: Стек переполнен!");
            return;
        }
        Link<Character> newLink = new Link<>(j);
        newLink.setNext(top);
        top = newLink;
        size++;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Ошибка: Стек пуст!");
            return '\0';
        }
        char data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Ошибка: Стек пуст!");
            return '\0';
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size > maxSize;
    }
}
