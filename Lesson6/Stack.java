package Lesson6;

public class Stack implements StackImpl {
    private int maxSize;
    private char[] stackArray;
    private int top;
    private boolean isOverflow;

    public Stack(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
        isOverflow = false;
    }

    public void push(char j) {
        if (isFull()) {
            if (!isOverflow) {
                System.out.println("Ошибка: Стек переполнен!");
                isOverflow = true;
            }
        } else {
            stackArray[++top] = j;
            isOverflow = false;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Ошибка: Стек пуст!");
            return '\0';
        }
        return stackArray[top--];
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Ошибка: Стек пуст!");
            return '\0';
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
