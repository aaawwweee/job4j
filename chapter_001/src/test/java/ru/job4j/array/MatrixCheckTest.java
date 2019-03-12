package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class MatrixCheckTest {
    @Test
    public void when2x2thenTrue() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true},
                {true, false}
        };
        boolean rst = matrix.mono(input);
        assertThat(rst,is(true));
    }
    @Test
    public void when2x2thenFalse() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true},
                {false, false}
        };
        boolean rst = matrix.mono(input);
        assertThat(rst,is(false));
    }
    @Test
    public void when3x3thenTrue() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true, false},
                {false, false, true},
                {false, true, false}
        };
        boolean rst = matrix.mono(input);
        assertThat(rst,is(true));
    }
    @Test
    public void when3x3thenFalse() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true, true},
                {false, false, true},
                {true, false, true}
        };
        boolean rst = matrix.mono(input);
        assertThat(rst,is(false));
    }
}