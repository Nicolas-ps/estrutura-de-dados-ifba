package queues;

public interface Queueable<T> {
    boolean enqueue(Object data);
    Object dequeue();
    Object front();
    boolean isEmpty();
    boolean isFull();
    String print();
}
