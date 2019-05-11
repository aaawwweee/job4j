package departments;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("k1/sk1");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("k1")),
                new Departments.Org(Arrays.asList("k1", "sk1"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissed1() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("K1")),
                new Departments.Org(Arrays.asList("K1", "SK1")),
                new Departments.Org(Arrays.asList("K1", "SK2")),
                new Departments.Org(Arrays.asList("K1", "SK1", "SSK1")),
                new Departments.Org(Arrays.asList("K1", "SK1", "SSK2")),
                new Departments.Org(Arrays.asList("K2")),
                new Departments.Org(Arrays.asList("K2", "SK1")),
                new Departments.Org(Arrays.asList("K2", "SK1", "SSK1")),
                new Departments.Org(Arrays.asList("K2", "SK1", "SSK2"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAsc() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("k1")),
                new Departments.Org(Arrays.asList("k1", "sk1")),
                new Departments.Org(Arrays.asList("k2"))
        );
        List<Departments.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    @Test
    public void whenAsc2() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("K1")),
                new Departments.Org(Arrays.asList("K1", "SK1")),
                new Departments.Org(Arrays.asList("K1", "SK1", "SSK1")),
                new Departments.Org(Arrays.asList("K1", "SK1", "SSK2")),
                new Departments.Org(Arrays.asList("K1", "SK2")),
                new Departments.Org(Arrays.asList("K2")),
                new Departments.Org(Arrays.asList("K2", "SK1")),
                new Departments.Org(Arrays.asList("K2", "SK1", "SSK1")),
                new Departments.Org(Arrays.asList("K2", "SK1", "SSK2"))
        );
        List<Departments.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    @Test
    public void whenDesc() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("k2")),
                new Departments.Org(Arrays.asList("k1")),
                new Departments.Org(Arrays.asList("k1", "sk1"))
        );
        List<Departments.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }

    @Test
    public void whenDesc1() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("K2")),
                new Departments.Org(Arrays.asList("K2", "SK1")),
                new Departments.Org(Arrays.asList("K2", "SK1", "SSK2")),
                new Departments.Org(Arrays.asList("K2", "SK1", "SSK1")),
                new Departments.Org(Arrays.asList("K1")),
                new Departments.Org(Arrays.asList("K1", "SK2")),
                new Departments.Org(Arrays.asList("K1", "SK1")),
                new Departments.Org(Arrays.asList("K1", "SK1", "SSK2")),
                new Departments.Org(Arrays.asList("K1", "SK1", "SSK1"))
        );
        List<Departments.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }
}