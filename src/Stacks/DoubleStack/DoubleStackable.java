package Stacks.DoubleStack;

import Stacks.Stack.ArrayStack;

public interface DoubleStackable {
    boolean push(ArrayStack arrayStack, Object data);
    boolean push(int arrayStackIndex, Object data);

    Object pop(ArrayStack arrayStack);
    Object pop(int arrayStackIndex);

    Object peek(ArrayStack arrayStack);
    Object peek(int arrayStackIndex);

    boolean isFull(ArrayStack arrayStack);
    boolean isFull(int arrayStackIndex);

    boolean isEmpty(ArrayStack arrayStack);
    boolean isEmpty(int arrayStackIndex);
}
