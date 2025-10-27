package lists;

import exceptions.OverflowException;
import queues.doubleEndedQueue.DoubleNode;

public class LinkedList<T> implements Listable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int capacity;
    private int amount;

    public LinkedList() {
        this(10);
    }

    public LinkedList(int capacity) {
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.amount = 0;
    }

    @Override
    public boolean insert(T data, int index) {
        return false;
    }

    @Override
    public boolean append(T data) {
        if (this.isFull()) {
            throw new OverflowException();
        }

        DoubleNode<T> newData = new DoubleNode<>();
        newData.setData(data);

        tail.setNext(newData);
        newData.setPrevious(tail);

        tail = newData;
        this.amount++;
        return true;
    }

    @Override
    public T select(int index) {
        return null;
    }

    @Override
    public T[] selectAll() {
        T[] temp = (T[]) new Object[this.size()];
        DoubleNode<T> aux = this.head;

        for (int i = 0; i < this.amount; i++) {
            temp[i] = aux.getData();
            aux = aux.getNext();
        }

        return temp;
    }

    @Override
    public boolean update(Object data, int index) {
        return false;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.amount = 0;
    }

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
        StringBuilder stringBuilder = new StringBuilder("[");
        DoubleNode<T> aux = this.head;
        for (int i = 0; i < this.amount; i++) {
            stringBuilder.append(aux.getData());

            if (i != this.amount - 1) {
                stringBuilder.append(",");
            }

            aux = aux.getNext();
        }


        return stringBuilder.append("]").toString();
    }

    @Override
    public int size() {
        return this.amount;
    }
}
