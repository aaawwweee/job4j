package ru.job4j.calculator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void whenTwentyTwoPlusFiveThenTwentySeven() {
        Calculator c = new Calculator();
        double rst = c.add(22D, 5D);
        double exp = 27D;
        assertThat(rst, is(exp));
    }
    @Test
    public void whenOneMinusOneThenZero() {
        Calculator c = new Calculator();
        double rst = c.subtract(1D, 1D);
        double exp = 0D;
        assertThat(rst, is(exp));
    }
    @Test
    public void whenSixDivSixThenOne() {
        Calculator c = new Calculator();
        double rst = c.div(6D, 6D);
        double exp = 1D;
        assertThat(rst, is(exp));
    }
    @Test
    public void whenOneMulSevenThenSeven() {
        Calculator c = new Calculator();
        double rst = c.multiple(1D, 7D);
        double exp = 7D;
        assertThat(rst, is(exp));
    }
}