package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class SquareTest {
    @Test
    public void when149() {
        Square square = new Square();
        int[] rst = square.calculate(3);
        int[] exp = {1, 4, 9};
        assertThat(rst, is(exp));
    }
    @Test
    public void when14916() {
        Square square = new Square();
        int[] rst = square.calculate(4);
        int[] exp = {1, 4, 9, 16};
        assertThat(rst, is(exp));
    }
}