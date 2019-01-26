package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayHomeTaskTest {
    @Test
    public void sortFirst() {
        int[] a = new int[]{3, 7, 8, 9, 13};
        int[] b = new int[]{1, 3, 5, 7, 10};
        int[] expected = new int[] {1, 3, 3, 5, 7, 7, 8, 9, 10, 13};
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] result = arrayHomeTask.sort(a, b);
        assertThat(result, is(expected));
    }

    @Test
    public void sortSecond() {
        int[] a = new int[]{2, 4, 8, 8, 11};
        int[] b = new int[]{1, 3, 5, 7, 13};
        int[] expected = new int[] {1, 2, 3, 4, 5, 7, 8, 8, 11, 13};
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] result = arrayHomeTask.sort(a, b);
        assertThat(result, is(expected));
    }

    @Test
    public void sortThird() {
        int[] a = new int[] {-11, -4, 0, 2};
        int[] b = new int[] {1, 51, 60, 62};
        int[] expected = new int[] {-11, -4, 0, 1, 2, 51, 60, 62};
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] result = arrayHomeTask.sort(a, b);
        assertThat(result, is(expected));
    }

    @Test
    public void sortFourth() {
        int[] a = new int[] {-5, 2, 7};
        int[] b = new int[] {-10, 6, 7, 8, 9, 32, 55};
        int[] expected = new int[] {-10, -5, 2, 6, 7, 7, 8, 9, 32, 55};
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] result = arrayHomeTask.sort(a, b);
        assertThat(result, is(expected));
    }

    @Test
    public void sortFifth() {
        int[] a = new int[] {-11, -5, 0, 45, 89, 90, 1555};
        int[] b = new int[] {-22, -21, 4, 44};
        int[] expected = new int[] {-22, -21, -11, -5, 0, 4, 44, 45, 89, 90, 1555};
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] result = arrayHomeTask.sort(a, b);
        assertThat(result, is(expected));
    }
}