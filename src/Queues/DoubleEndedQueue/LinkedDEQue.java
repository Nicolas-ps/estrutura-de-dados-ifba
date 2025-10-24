package Queues.DoubleEndedQueue;

import Queues.Queueable;

public class LinkedDEQue<T> implements Queueable<T> {
    private final int amount;
    private final int capacity;
    DoubleNode<T> head;
    DoubleNode<T> tail;

    public LinkedDEQue() {
        this(10);
    }

    public LinkedDEQue(int capacity) {
        amount = 0;
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean enqueue(Object data) {
        return false;
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object front() {
        return null;
    }

    /**
     * Verifica se a fila está vazia
     * @return true se a fila está ou não vazia. Falso do contrário.
     */
    @Override
    public boolean isEmpty() {
        return this.amount == 0;
    }

    @Override
    public boolean isFull() {
        return this.amount == this.capacity;
    }

    @Override
    public String print() {
        return "";
    }
}
