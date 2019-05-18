package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 18.05.2019
 * @version 2
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] values;
    private int index = 0;

    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return Arrays
                .stream(values)
                .skip(index)
                .filter(i -> i % 2 == 0)
                .count() > 0;
    }

    @Override
    public Integer next() {
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                index = i + 1;
                return values[i];
            }
        }
        throw new NoSuchElementException();
    }
}
