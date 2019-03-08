package ru.job4j.condition;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle();
        double result = triangle.area(0, 0, 0, 2, 2, 0);
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}