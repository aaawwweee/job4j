package ru.job4j.array;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindLoopTest {
    @Test
    public void whenFindEl() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[] {3, 7, -5};
        int value = -5;
        int rst = findLoop.indexOf(input, value);
        int exp = 2;
        assertThat(rst, is(exp));
    }
    @Test
    public void whenNoElement() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int value = 6;
        int rst = findLoop.indexOf(input, value);
        int expect = -1;
        assertThat(rst, is(expect));
    }
}