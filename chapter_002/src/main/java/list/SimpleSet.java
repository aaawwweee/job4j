package list;
import java.util.Iterator;
import java.util.Objects;

/**
 * SimpleSet on ArrayContainer
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 02.06.2019
 * @version 1
 * @param <E> - generic
 */

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArrayContainer<E> container;

    public SimpleSet() {
        this.container = new SimpleArrayContainer<E>();
    }

    public boolean add(E value) {
        boolean result = false;
        if (!checkDuplicate(value)) {
            this.container.add(value);
            result = true;

        }
        return result;
    }

    private boolean checkDuplicate(E value) {
        boolean result = false;
        if (this.container != null) {
            for (Object x : this.container) {
                if (Objects.equals(x, value)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}