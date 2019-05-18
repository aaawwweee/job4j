package iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 18.05.2019
 * @version 1
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> newIt = it.next();

            @Override
            public boolean hasNext() {
                while(!newIt.hasNext() && it.hasNext()) {
                    newIt = it.next();
                }
                return newIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return newIt.next();
            }
        };
    }
}