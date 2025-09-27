package Stacks.DoubleStack;

public class DoubleArrayStack implements DoubleStackable {
    private int pointTopStackOne;
    private int pointTopStackTwo;
    private final Object[] data;

    public DoubleArrayStack() {
        this(10);
    }

    public DoubleArrayStack(int length) {
        this.pointTopStackOne = 0;
        this.pointTopStackTwo = length / 2;
        this.data = new Object[length];
    }

    @Override
    public boolean push(int arrayStackIndex, Object data) {
        if (arrayStackIndex == 1) {
            this.data[pointTopStackOne] = data;
            pointTopStackOne++;
            return true;
        }

        if (arrayStackIndex == 2) {
            this.data[pointTopStackTwo] = data;
            pointTopStackTwo++;
            return true;
        }

        return false;
    }

    @Override
    public Object pop(int arrayStackIndex) {
        if (arrayStackIndex == 1) {
            this.data[pointTopStackOne] = null;
            pointTopStackOne--;
            return true;
        }

        if (arrayStackIndex == 2) {
            this.data[pointTopStackTwo] = null;
            pointTopStackTwo--;
            return true;
        }

        return false;
    }

    @Override
    public Object peek(int arrayStackIndex) {
        if (arrayStackIndex == 1) {
           return this.data[pointTopStackOne];
        }

        if (arrayStackIndex == 2) {
            return this.data[pointTopStackTwo];
        }

        return null;
    }

    @Override
    public boolean isFull(int arrayStackIndex) {
        if (arrayStackIndex == 1) {
            return pointTopStackOne == ((data.length / 2) - 1);
        }

        if (arrayStackIndex == 2) {
            return pointTopStackTwo == (data.length - 1);
        }

        return false;
    }

    @Override
    public boolean isEmpty(int arrayStackIndex) {
        if (arrayStackIndex == 1) {
            return pointTopStackOne == 0;
        }

        if (arrayStackIndex == 2) {
            return pointTopStackTwo == (data.length / 2);
        }

        return true;
    }

    @Override
    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(i).append(" - ").append(this.data[i]).append("\n");
        }

        System.out.print(stringBuilder);
    }
}
