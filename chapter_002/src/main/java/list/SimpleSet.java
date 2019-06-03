package list;
import java.util.Iterator;

/**
 * SimpleSet on ArrayContainer
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 02.06.2019
 * @version 1
 * @param <T> - generic
 */

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArrayContainer<T> container;

    public SimpleSet() {
        this.container = new SimpleArrayContainer<>();
    }

    public boolean add(T value) {
        boolean result = false;
        if (!checkDuplicate(value)) {
            result = true;
            this.container.add(value);
        }
        return result;
    }

    private boolean checkDuplicate(T value) {
        boolean result = false;
        if (this.container != null) {
            for(Object x : this.container) {
                if (value.equals(x)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return this.container.iterator();
    }
}