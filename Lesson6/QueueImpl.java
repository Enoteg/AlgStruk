package Lesson6;

public interface QueueImpl {
    void insert(long j);
    long remove();
    long peekFront();
    boolean isEmpty();
    boolean isFull();
    int size();
    void display();
}
