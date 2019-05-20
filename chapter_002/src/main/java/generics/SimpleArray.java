package generics;
import java.util.*;
/**
 * @author Alexander Kashkin(kashkinmsk@gmail.com)
 * @since 20.05.19
 * @version 1
 * @param <T> - param-param
 */
public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;

    }
    public void set(int index, T model) {
        this.objects[index] = model;
    }
    public void remove(int index) {
        System.arraycopy(objects, index + 1, objects, index, objects.length - 1 - index);
        this.index--;
    }
    @SuppressWarnings("unchecked")
    public T get(int position) {
        return (T) this.objects[position];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return objects.length > index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                };
                return (T) objects[index++];
            }
        };
    }
}