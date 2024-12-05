package Lesson7;

public class Link<T> {
    private T data;
    private Link<T> next;

    public Link(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
