package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class MatrixTest {
    @Test
    public void when3x3() {
        Matrix matrix = new Matrix();
        int[][] input = matrix.multiple(3);
        int[][] exp = {
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}
        };
        assertThat(input, is(exp));
    }
    @Test
    public void when2x2() {
        Matrix matrix = new Matrix();
        int[][] input = matrix.multiple(2);
        int[][] exp = {
                {1, 2},
                {2, 4}
        };
        assertThat(input, is(exp));
    }
}