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
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if  (values[i] % 2 == 0) {
                result = true;
                index = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            if (values[index] % 2 != 0) {
                index++;
            }
            return values[index++];
            }
        }
}
