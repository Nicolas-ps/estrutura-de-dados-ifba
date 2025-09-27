package Stacks.DoubleStack;

public class DoubleArrayStack implements DoubleStackable {
    private int pointTopStackOne;
    private int pointTopStackTwo;
    private final Object[] data;

    public DoubleArrayStack() {
        this(10);
    }

    public DoubleArrayStack(int length) {
        this.pointTopStackOne = -1;
        this.pointTopStackTwo = (length / 2) - 1;
        this.data = new Object[length];
    }

    @Override
    public boolean push(int arrayStackIndex, Object data) {
        if (this.isFull(arrayStackIndex)) {
            return false;
        }

        if (arrayStackIndex == 1) {
            pointTopStackOne++;
            this.data[pointTopStackOne] = data;
            return true;
        }

        if (arrayStackIndex == 2) {
            pointTopStackTwo++;
            this.data[pointTopStackTwo] = data;
            return true;
        }

        return false;
    }

    @Override
    public Object pop(int arrayStackIndex) {
        if (this.isEmpty(arrayStackIndex)) {
            return null;
        }

        if (arrayStackIndex == 1) {
            Object element = this.data[pointTopStackOne];
            this.data[pointTopStackOne] = null;
            pointTopStackOne--;
            return element;
        }

        if (arrayStackIndex == 2) {
            Object element = this.data[pointTopStackTwo];
            this.data[pointTopStackTwo] = null;
            pointTopStackTwo--;
            return element;
        }

        return null;
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
            return pointTopStackOne == -1;
        }

        if (arrayStackIndex == 2) {
            return pointTopStackTwo == (data.length / 2) - 1;
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
