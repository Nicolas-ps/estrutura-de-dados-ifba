package Stacks.DoubleStack;

public interface DoubleStackable {
    boolean push(int arrayStackIndex, Object data);
    Object pop(int arrayStackIndex);
    Object peek(int arrayStackIndex);
    boolean isFull(int arrayStackIndex);
    boolean isEmpty(int arrayStackIndex);
}
