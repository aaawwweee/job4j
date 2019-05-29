package list;
/**
 * @author Alexander Kashkin (kashkinmskgmail.com)
 * @since 24.05.2019
 * @version 1
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleListContainerTest {
    SimpleListContainer<Integer> slc;
    Iterator it;
    @Before
    public void addSomeElements() {
        slc = new SimpleListContainer<>();
        slc.add(1);
        slc.add(2);
        slc.add(3);
        it = slc.iterator();
    }
    @Test
    public void getElementsByIndex() {
        assertThat(slc.get(0), is(1));
        assertThat(slc.get(1), is(2));
        assertThat(slc.get(2), is(3));
    }
    @Test
    public void getLastAndRemoveIt() {
        assertThat(slc.getLast(), is(3));
        slc.add(4);
        assertThat(slc.getLast(), is(4));
        slc.removeLast();
        assertThat(slc.getLast(), is(3));
    }
    @Test
    public void getFirstAndRemoveIt() {
        assertThat(slc.getFirst(), is(1));
        slc.removeFisrt();
        assertThat(slc.getFirst(), is(2));
    }
    @Test
    public void getSize() {
        assertThat(slc.getSize(), is(3));
    }
    @Test
    public void checkByIterator() {
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}