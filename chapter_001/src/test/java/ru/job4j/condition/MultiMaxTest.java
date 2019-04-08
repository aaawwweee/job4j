package ru.job4j.condition;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MultiMaxTest {
    @Test
    public void whenMaxOf1and4and3() {
        MultiMax multiMax = new MultiMax();
        int rst = multiMax.max(1, 4, 3);
        assertThat(rst, is(4));
    }
    @Test
    public void whenMaxOf1and1and1() {
        MultiMax multiMax = new MultiMax();
        int rst = multiMax.max(1, 1, 1);
        assertThat(rst, is(1));
    }
    @Test
    public void whenMaxOf2and1and1() {
        MultiMax multiMax = new MultiMax();
        int rst = multiMax.max(2, 1, 1);
        assertThat(rst, is(2));
    }
    @Test
    public void whenMaxOf1and2and9() {
        MultiMax multiMax = new MultiMax();
        int rst = multiMax.max(1, 2, 9);
        assertThat(rst, is(9));
    }
}