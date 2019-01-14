package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.index0f(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    @Test
    public void whenNoElementInArrayThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        int value = 10;
        int result = find.index0f(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLength10Then9() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = 10;
        int result = find.index0f(input, value);
        int expect = 9;
        assertThat(result, is(expect));
    }
}