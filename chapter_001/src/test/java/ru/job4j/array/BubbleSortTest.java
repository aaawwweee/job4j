package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void when426423Then223446() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {4, 2, 6, 4, 2, 3};
        int[] rst = bubbleSort.sort(input);
        int[] exp = new int[] {2, 2, 3, 4, 4, 6};
        assertThat(rst, is(exp));
    }
    @Test
    public void whenMinus52563ThenMinus52356() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] coming = new int[] {-5, 2, 5, 6, 3};
        int[] exp = new int[] {-5, 2, 3, 5, 6};
        assertThat(bubbleSort.sort(coming), is(exp));
    }
}