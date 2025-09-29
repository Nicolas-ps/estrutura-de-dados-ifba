package Lists;

public interface Listable {
    boolean insert(Object data, int index);
    boolean append(Object data);
    Object select(int index);
    Object[] selectAll();
    boolean update(Object data, int index);
    Object delete(int index);
    void clear();
    boolean isEmpty();
    boolean isFull();
    String print();
}
