package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] incoming = {1, 2, 5, 3, 8, 5, 0, 3, 1, 11};
        int[] expected = {0, 1, 1, 2, 3, 3, 5, 5, 8, 11};
        assertThat(bubble.sort(incoming), is(expected));
    }
}