package ru.job4j.loop;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactorialTest {
    @Test
    public void whenFactIs3() {
        Factorial fact = new Factorial();
        int rst = fact.calc(3);
        assertThat(rst, is(6));
    }
    @Test
    public void whenFactIs5() {
        Factorial fact = new Factorial();
        int rst = fact.calc(5);
        assertThat(rst, is(120));
    }
}
