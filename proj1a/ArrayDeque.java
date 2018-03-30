public class ArrayDeque<T> {
    private int size;
    private T[] items;

    public ArrayDeque(T item) {
        items = (T[]) new Object[100];
        items[0] = item;
        size = 1;
    }

    public ArrayDeque() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void resize(int x) {
        T[] a = (T[]) new Object[size * x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFist(T item) {
        T[] a;
        if (size == items.length) {
            a = (T[]) new Object[items.length * 2];
        } else {
            a = (T[]) new Object[items.length];
        }
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        items[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(2);
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

    public T removeFirst() {
        T[] a;
        T returnItem = items[0];
        if (size == items.length) {
            a = (T[]) new Object[items.length * 2];
        } else {
            a = (T[]) new Object[items.length];
        }
        System.arraycopy(items, 1, a, 0, size - 1);
        items = a;
        size -= 1;

        return returnItem;
    }

    public T removeLast() {
        T returnItem = items[size - 1];
        items[size - 1] = null;
        size -= 1;

        return returnItem;
    }

    public T get(int index) {
        return items[index];
    }

}
