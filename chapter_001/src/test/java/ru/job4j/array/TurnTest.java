package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TurnTest {
    @Test
    public void checkArrayIfEven() {
        Turn loop = new Turn();
        int[] incoming = {6, 2, 4, 2, 3, 1};
        int[] expected = {1, 3, 2, 4, 2, 6};
        assertThat(loop.array(incoming), is(expected));
    }
    @Test
    public void checkArrayIfOdd() {
        Turn loop = new Turn();
        int[] incoming = {4, 8, 9, 3, 2, 0, 1};
        int[] expected = {1, 0, 2, 3, 9, 8, 4};
        assertThat(loop.array(incoming), is(expected));
    }
}