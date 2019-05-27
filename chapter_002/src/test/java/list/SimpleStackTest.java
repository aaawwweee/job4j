package list;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
public class SimpleStackTest {
    @Test
    public void whenPushAndPollValues() {
        SimpleStack<String> stringSimpleStack = new SimpleStack<>();
        stringSimpleStack.push("1");
        stringSimpleStack.push("2");
        stringSimpleStack.push("3");
        assertThat(stringSimpleStack.poll(), is("3"));
        assertThat(stringSimpleStack.poll(), is("2"));
        assertThat(stringSimpleStack.poll(), is("1"));

    }
}
