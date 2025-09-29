package Queue;

public interface Queueable {
    boolean enqueue(Object data);
    Object dequeue();
    Object front();
    boolean isEmpty();
    boolean isFull();
    String print();
}
