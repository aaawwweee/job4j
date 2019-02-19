package tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }
    @After
    public void loadSys() {
        System.setOut(this.out);
    }
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"Invalid", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter validate data again.%n")
                )
        );
    }
    @Test
    public void whenKeyIsOutOfMenu() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"10", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, select key from menu%n")
                )
        );
    }
}