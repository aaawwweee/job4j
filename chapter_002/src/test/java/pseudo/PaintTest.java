package pseudo;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("+ + + +")
                                .append("+ + + +")
                                .append("+ + + +")
                                .append("+ + + +")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("  ^  ")
                                .append(" ^^^ ")
                                .append("^^^^^")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}