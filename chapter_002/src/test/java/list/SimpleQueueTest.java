package list;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleQueueTest {
    @Test
    public void whenPushAndPoll() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("1");
        simpleQueue.push("2");
        simpleQueue.push("3");
        assertThat(simpleQueue.poll(), is("1"));
        assertThat(simpleQueue.poll(), is("2"));
        assertThat(simpleQueue.poll(), is("3"));
    }
}