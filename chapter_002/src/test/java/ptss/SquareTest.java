package ptss;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SquareTest {
    @Test
    public void ifDrawSquare() {
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
