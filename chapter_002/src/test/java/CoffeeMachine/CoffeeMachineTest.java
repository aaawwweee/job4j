package CoffeeMachine;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void testOne() {
        CoffeeMachine cm = new CoffeeMachine();
        assertThat(cm.changes(40, 8), is(new int[] {10, 10, 10, 2}));
    }
    @Test
    public void testTwo() {
        CoffeeMachine cm = new CoffeeMachine();
        assertThat(cm.changes(100, 66), is(new int[] {10, 10, 10, 2, 2}));
    }
}
