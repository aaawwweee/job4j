package pseudo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(), is(
                        new StringBuilder()
                        .append("  ^  ")
                        .append(" ^^^ ")
                        .append("^^^^^")
                        .toString()
                )
        );
    }
}
