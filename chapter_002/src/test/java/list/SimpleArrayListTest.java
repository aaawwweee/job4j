package list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
    @Test
    public void whenDeleteFirstElement() {
        var deleted = list.get(0);
        var nextFirst = list.get(1);
        assertThat(list.delete(), is(deleted));
        assertThat(list.get(0), is(nextFirst));
        assertThat(list.getSize(), is(2));
    }
}