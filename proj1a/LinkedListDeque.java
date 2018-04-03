public class LinkedListDeque<T> {
    private TNode sentinel;
    private TNode first;
    private int size;

    public LinkedListDeque(T item) {
        sentinel = new TNode(null, null, null);
        TNode node = new TNode(sentinel, item, sentinel);
        sentinel.next = node;
        sentinel.prev = node;
        size = 1;
    }

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        size = 0;
    }

    public class TNode {
        private TNode prev;
        private T current;
        private TNode next;

        public TNode(TNode p, T item, TNode n) {
            prev = p;
            current = item;
            next = n;
        }
    }

    public void addFirst(T item) {
        if (size == 0) {
            TNode node = new TNode(sentinel, item, sentinel);
            sentinel.next = node;
            sentinel.prev = node;
        } else {
            TNode node = new TNode(sentinel, item, sentinel.next);
            sentinel.next = node;
            node.next.prev = node;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == 0) {
            TNode node = new TNode(sentinel, item, sentinel);
            sentinel.next = node;
            sentinel.prev = node;
        } else {
            TNode node = new TNode(sentinel.prev, item, sentinel);
            sentinel.prev = node;
            node.prev.next = node;
        }
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
            System.out.println(this.get(i));
        }

    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        TNode node = sentinel.next;
        T item = node.current;
        sentinel.next = node.next;
        node.next.prev = sentinel;
        size -= 1;

        return item;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        TNode node = sentinel.prev;
        T item = node.current;
        sentinel.prev = node.prev;
        node.prev.next = sentinel;
        size -= 1;

        return item;
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        TNode temp = new TNode(null, null, sentinel.next);
        for (int i = 0; i < index; i++) {
            temp.next = temp.next.next;
        }
        return temp.next.current;
    }

    public T getRecursive(int index) {
        //TODO
        return null;
    }
}
