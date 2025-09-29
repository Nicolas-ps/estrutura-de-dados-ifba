package Queues.ArrayQueue;

public class ArrayQueue implements Queueable {
    private final Object[] data;
    private int head;
    private int tail;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int length) {
        this.data = new Object[length];
        this.head = 0;
        this.tail = -1;
    }

    @Override
    public boolean enqueue(Object data) {
        if (this.isFull()) {
            return false;
        }

        this.tail++;
        this.data[this.tail] = data;
        return true;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }

        Object element = this.data[this.head];
        this.data[this.head] = null;
        this.head++;
        return element;
    }

    @Override
    public Object front() {
        if (isEmpty()) {
            return null;
        }

        return this.data[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.tail == this.head - 1;
    }

    @Override
    public boolean isFull() {
        return this.tail == this.data.length - 1;
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = head; i <= tail; i++) {
            result.append(data[i]);
            if (i != tail) {
                result.append(", ");
            }
        }

        return "[" + result + "]";
    }
}
