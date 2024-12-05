package Lesson7;

public interface QueueImpl<T> {
    void insert(T item);
    T remove();
    T peekFront();
    boolean isEmpty();
    int size();
    void display();
}
