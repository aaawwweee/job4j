package ru.job4j.condition;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class PointTest {
    @Test
    public void whenZeroAndTenThen10() {
        Point point = new Point();
        double rst = point.distance(0, 0, 0, 10);
        assertThat(rst, is(10D));
    }
}