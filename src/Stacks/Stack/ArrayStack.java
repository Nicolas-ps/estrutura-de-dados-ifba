package Stacks.Stack;

import Stacks.Stackable;

public class ArrayStack implements Stackable {
    private final Object[] data;
    private int topIndex;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int length) {
        this.data = new Object[length];
        this.topIndex = 0;
    }

    @Override
    public boolean push(Object data) {
        if (isFull()) {
            return false;
        }

        this.data[topIndex] = data;
        topIndex++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }

        Object value = this.data[topIndex - 1];
        this.data[topIndex - 1] = null;
        topIndex--;

        return value;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return this.data[topIndex - 1];
    }

    @Override
    public boolean isFull() {
        return this.topIndex > (this.data.length - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.topIndex == 0;
    }

    public String print() {
        StringBuilder formattedStack = new StringBuilder();

       for (int i = 0; i < this.data.length; i++) {
            formattedStack.append("\n").append(i).append(" - ").append(this.data[i]);
       }

       return formattedStack.toString();
    }
}
