package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (capacity == 0 | fillCount == capacity) {
            throw new RuntimeException("Ring buffer underflow");
        }
        rb[last] = x;
        last += 1;
        if (last == capacity) {
            last = 0;
        }
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T returnVal = rb[first];
        rb[first] = null;
        first += 1;
        if (first == capacity) {
            first = 0;
        }
        fillCount -= 1;

        return returnVal;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        T returnVal = rb[first];

        return returnVal;
    }

    // When you get to part 5, implement the needed code to support iteration.
    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T>{
        private int position;
        private int count;

        public ArrayRingBufferIterator() {
            position = first;
            count = 0;
        }

        @Override
        public T next() {
            T returnVal = rb[position];
            position += 1;
            count += 1;
            if (position == capacity) {
                position = 0;
            }
            return returnVal;
        }

        @Override
        public boolean hasNext() {
            return (count != fillCount);
        }
    }
}
