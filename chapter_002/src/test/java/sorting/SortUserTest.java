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
    @Test
    public void whenSortedByNamesLength() {
        List<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        list.add(new User("Pasha", 17));
        list.add(new User("Sasha", 27));
        list.add(new User("Lena", 31));
        List<User> result = sortUser.sortNameLength(list);
        assertThat(result.iterator().next().getName(), is("Lena"));
    }
    @Test
    public void whenFirstSortedByNameThenByAge() {
        List<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        list.add(new User("Pasha", 17));
        list.add(new User("Sasha", 27));
        list.add(new User("Lena", 31));
        list.add(new User("Afanasiy", 53));
        list.add(new User("Bogdan", 5));
        List<User> result = sortUser.sortByAllFields(list);
        assertThat(result.iterator().next().getName(), is("Afanasiy"));
    }
}
