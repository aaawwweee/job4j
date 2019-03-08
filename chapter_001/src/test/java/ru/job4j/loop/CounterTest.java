package ru.job4j.loop;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CounterTest {
    @Test
    public void whenSumEvenNumberFrom1ToTenThenThirty() {
        Counter counter = new Counter();
        int rst = counter.add(1, 10);
        assertThat(rst, is(30));
    }
}