package list;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 24.05.2019
 * @version 1
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayContainer<E> implements Iterable<E> {

    private static final int CAPACITY = 100;
    private Object[] container;
    private int count = 0;
    private int modCount = 0;

    public SimpleArrayContainer() {
        this.container = new Object[CAPACITY];
    }

    public void add(E value) {
        if (count == container.length) {
            Object[] xArray = new Object[container.length + CAPACITY];
            System.arraycopy(container, 0, xArray, 0, container.length);
            container = xArray;
            modCount++;
        }
        container[count++] = value;
    }

    public E get(int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException();
        }
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Integer index = 0;
            private final Integer expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < count;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }
        };
    }
}