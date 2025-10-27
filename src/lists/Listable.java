package lists;

public interface Listable<T> {
    boolean insert(T data, int index);
    boolean append(T data);
    T select(int index);
    T[] selectAll();
    boolean update(T data, int index);
    T delete(int index);
    void clear();
    boolean isEmpty();
    boolean isFull();
    String print();
    int size();

}
