package Lists.ArrayLists;

import Lists.Listable;

public class ArrayList implements Listable {
    private final Object[] data;
    private int head;
    private int tail;
    private int quantity;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int length) {
        this.data = new Object[length];
        this.head = 0;
        this.tail = -1;
        this.quantity = 0;
    }

    @Override
    public Object select(int index) throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            return null;
        }

        if (index < 0 || index >= this.quantity) {
            throw new IndexOutOfBoundsException();
        }

        int physicIndex = this.map(index);
        return this.data[physicIndex];
    }

    @Override
    public Object[] selectAll() {
        if (isEmpty()) {
            return null;
        }

        Object[] buffer = new Object[this.quantity];
        int index = head;

        for (int i = 0; i < this.quantity; i++) {
            buffer[i] = this.data[index];
            index = this.next(index);
        }

        return buffer;
    }

    @Override
    public boolean insert(Object data, int index) {
        if (this.isFull()) {
            return false;
        }

        if (index < 0 || index >= this.quantity) {
            throw new IndexOutOfBoundsException();
        }

        int physicIndex = this.map(index);
        int i = this.tail;
        this.tail = this.next(tail);

        for (; i != this.prev(physicIndex); i = this.prev(i)) {
            this.data[this.next(i)] = this.data[i];
        }

        this.data[physicIndex] = data;
        this.quantity++;
        return true;
    }

    @Override
    public boolean append(Object data) {
        if (this.isFull()) {
            return false;
        }

        this.tail++;
        this.data[this.tail] = data;
        this.quantity++;
        return true;
    }

    @Override
    public boolean update(Object data, int index) {
        if (this.isEmpty()) {
            return false;
        }

        if (index < 0 || index >= this.quantity) {
            throw new IndexOutOfBoundsException();
        }

        int physicIndex = this.map(index);
        this.data[physicIndex] = data;
        return true;
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            return null;
        }

        if (index < 0 || index >= this.quantity) {
            throw new IndexOutOfBoundsException();
        }

        int physicIndex = this.map(index);
        Object element = this.data[physicIndex];

        for (int i = physicIndex; i != tail; i = this.next(index)) {
            this.data[i] = this.data[this.next(i)];
        }

        this.data[this.tail] = null;
        this.tail = this.prev(this.tail);
        this.quantity--;

        return element;
    }

    @Override
    public void clear() {
        this.head = 0;
        this.tail = -1;
        this.quantity = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.quantity == 0;
    }

    @Override
    public boolean isFull() {
        return this.quantity == data.length;
    }

    @Override
    public String print() {
        StringBuilder buffer = new StringBuilder();
        int aux = head;

        for(int i = 0; i < quantity; i++) {
            buffer.append(data[aux]);
            aux = next(aux);
            if (i != quantity - 1) {
                buffer.append(", ");
            }
        }

        return "[" + buffer + "]";
    }

    private int next(int index) {
        return (index + 1) % this.data.length;
    }

    private int prev(int index) {
        return (this.data.length + index - 1) % this.data.length;
    }

    private int map(int index) {
        return (this.head + index) % this.data.length;
    }
}
