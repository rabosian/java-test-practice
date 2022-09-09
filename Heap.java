import java.util.Comparator;

public class Heap<E> {
    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] array;

    // constructor1: non allocating initial memory
    public Heap() {
        this(null);
    }
    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // constructor2: allocating initial memory
    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParant(int index) {
        return index / 2;
    }
    private int getLeftChild(int index) {
        return index * 2;
    }
    private int getRightChild(int index) {
        return index * 2 + 1;
    }
}
