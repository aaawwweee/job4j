package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TurnTest {
    @Test
    public void when14910Then10941() {
        Turn turn = new Turn();
        int[] input = new int[] {1, 4, 9, 10};
        int[] rst = turn.back(input);
        int[] exp = {10, 9, 4, 1};
        assertThat(rst, is(exp));
    }
    @Test
    public void when1491011Then1110941() {
        Turn turn = new Turn();
        int[] input = new int[] {1, 4, 9, 10, 11};
        int[] rst = turn.back(input);
        int[] exp = {11, 10, 9, 4, 1};
        assertThat(rst, is(exp));
    }
}