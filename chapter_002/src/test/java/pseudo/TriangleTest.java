package pseudo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String nLine = System.lineSeparator();
        assertThat(
                triangle.draw(), is(
                        new StringBuilder()
                        .append("  ^  ").append(nLine)
                        .append(" ^^^ ").append(nLine)
                        .append("^^^^^")
                        .toString()
                )
        );
    }
}