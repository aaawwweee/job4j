package generics;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class SimpleArrayTest {
    @Test
    public void whenAddRemoveSomeArrayList() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(10);
        simpleArray.add(0);
        simpleArray.remove(0);
        simpleArray.add(1);
        simpleArray.add(2);
        Integer result = simpleArray.iterator().next();
        Integer expected = 1;
        assertThat(result, is(expected));
        assertThat(simpleArray.iterator().hasNext(), is(true));
    }
    @Test
    public void whenSetSomeNewValue() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(10);
        simpleArray.add(0);
        simpleArray.set(0, 99);
        Integer result = simpleArray.get(0);
        assertThat(result, is(99));
    }
}