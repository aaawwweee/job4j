package ru.job4j.array;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class CheckTest {
    @Test
    public void whenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean rst = check.mono(input);
        assertThat(rst, is(true));
    }
    @Test
    public void whenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, true};
        boolean rst = check.mono(input);
        assertThat(rst, is(false));
    }
    @Test
    public void whenTrue1() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean rst = check.mono(input);
        assertThat(rst, is(true));
    }
    @Test
    public void whenFalse1() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, true, false};
        boolean rst = check.mono(input);
        assertThat(rst, is(false));
    }
}