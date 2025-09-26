package Stacks.DoubleStack;

public class DoubleArrayStack implements DoubleStackable {
    private int pointTopStackOne;
    private int pointTopStackTwo;
    private Object data;

    public DoubleArrayStack(int length) {
        this.pointTopStackOne = 0;
        this.pointTopStackTwo = length;
        this.data = new Object[length];
    }

    @Override
    public boolean push(int arrayStackIndex, Object data) {
        return false;
    }

    @Override
    public Object pop(int arrayStackIndex) {
        return null;
    }

    @Override
    public Object peek(int arrayStackIndex) {
        return null;
    }

    @Override
    public boolean isFull(int arrayStackIndex) {
        return false;
    }

    @Override
    public boolean isEmpty(int arrayStackIndex) {
        return false;
    }
}
