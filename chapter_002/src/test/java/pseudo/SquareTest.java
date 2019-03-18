package pseudo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                        .append("+ + + +")
                        .append("+ + + +")
                        .append("+ + + +")
                        .append("+ + + +")
                        .toString()
                )
        );
    }
}
