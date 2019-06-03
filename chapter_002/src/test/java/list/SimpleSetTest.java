package list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleSetTest {
    SimpleSet<Integer> simpleSet;
    @Before
    public void whenSetHasNoDuplicatesAfterAddingElements() {
        simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
    }
    @Test
    public void whenAddAddTheSameElementThatFalse() {
        assertThat(simpleSet.add(1), is(false));
    }
    @Test
    public void whenAddSomeDifferentElementThatTrue() {
        assertThat(simpleSet.add(4), is(true));
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementAfterCreatingIterator() {
        Iterator<Integer> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is(1));
        simpleSet.add(4);
        iterator.next();
    }
}