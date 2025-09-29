package Stacks;

public interface Stackable {
    boolean push(Object data);
    Object pop();
    Object peek();

    boolean isFull();
    boolean isEmpty();
}
