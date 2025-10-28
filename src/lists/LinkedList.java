package lists;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import queues.doubleEndedQueue.DoubleNode;

public class LinkedList<T> implements Listable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private final int capacity;
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

        if (! this.isEmpty()) {
            this.tail.setNext(newData);
        } else  {
            this.head = newData;
            newData.setPrevious(tail);
            tail = newData;
            this.amount++;
        }

        return true;
    }

    @Override
    public T select(int index) {
        if (this.isEmpty()) {
            throw new UnderflowException();
        }

        DoubleNode<T> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }

        return aux.getData();
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
    public boolean update(T data, int index) {
        if (this.isEmpty()) {
            throw new UnderflowException();
        }

        if (index < 0 || index > this.amount - 1) {
            throw new IndexOutOfBoundsException();
        }

        DoubleNode<T> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }

        aux.setData(data);
        return true;
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
