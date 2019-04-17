package lambda;
import java.util.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LambdsTest {
    private static Lambds lambds = new Lambds();
    @Test
    public void whenLinearFunction() {
        List<Double> result = lambds.diapason(2, 6, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(5D, 7D, 9D, 11D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunction() {
        List<Double> result = lambds.diapason(1, 3, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogarithmicFunction() {
        List<Double> result = lambds.diapason(5, 8, Math :: log);
        List<Double> expected = Arrays.asList(1.6094379124341003, 1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }
}
