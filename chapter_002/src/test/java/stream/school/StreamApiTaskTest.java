package stream.school;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StreamApiTaskTest {
    @Test
    public void whenFilterSum() {
        StreamApiTask streamApiTask = new StreamApiTask();
        Integer[] array = new Integer[] {1, 2, 4, 5, 7, 9, 11};
        Integer result = streamApiTask.streamMethod(array);
        assertThat(result, is(20));
    }
    public void whenFilterSum1() {
        StreamApiTask streamApiTask = new StreamApiTask();
        Integer[] array = new Integer[] {2, 1, 1, 1, 1, 1, 1};
        Integer result = streamApiTask.streamMethod(array);
        assertThat(result, is(4));
    }
}