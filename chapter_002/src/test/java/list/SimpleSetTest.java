package list;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleSetTest {
    private SimpleSet<Integer> simpleSet;
    @Before
    public void whenSetHasNoDuplicatesAfterAddingElements() {
        simpleSet = new SimpleSet<Integer>();
        simpleSet.add(3);
        simpleSet.add(null);
        simpleSet.add(5);
        simpleSet.add(5);
    }
    @Test
    public void whenCheckByIterator() {
        Iterator<Integer> it = simpleSet.iterator();
        assertThat(it.next(), is(3));
        assertNull(it.next());
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }

}