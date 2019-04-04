package sorting;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void whenSorted() {
        List<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        list.add(new User("Pasha", 67));
        list.add(new User("Sasha", 27));
        list.add(new User("Lena", 31));
        Set<User> result = sortUser.sort(list);
        assertThat(result.iterator().next().getName(), is("Sasha"));
        assertThat(result.iterator().hasNext(), is(true));
    }
}
