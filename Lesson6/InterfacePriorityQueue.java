package Lesson6;

public interface InterfacePriorityQueue {
    void insert(long item);
    long remove();
    long peekMin();
    boolean isEmpty();
    boolean isFull();
    void display();
}
