package list;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class SimpleArrayContainerTest {
    SimpleArrayContainer<Integer> sac;
    Iterator iterator;
    @Before
    public void createList() {
        sac = new SimpleArrayContainer<>();
        sac.add(1);
        sac.add(2);
        sac.add(3);
        iterator = sac.iterator();
    }
    @Test
    public void whenGetSomeElements() {
        assertThat(sac.get(0), is(1));
    }
    @Test
    public void checkIterator() {
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }
}