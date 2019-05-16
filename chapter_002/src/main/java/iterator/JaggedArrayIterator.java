package iterator;

import java.util.Iterator;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 16.05.2019
 * @version 1
 */
public class JaggedArrayIterator implements Iterator<Integer> {
    private final int[][] values;
    private int firstIndex;
    private int secondIndex;

    public JaggedArrayIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length - 1 > firstIndex
                || values[firstIndex].length > secondIndex;
    }

    @Override
    public Integer next() {
        if (secondIndex == values[firstIndex].length) {
            return values[++firstIndex][0];
        } else {
            return values[firstIndex][secondIndex++];
        }
    }
}