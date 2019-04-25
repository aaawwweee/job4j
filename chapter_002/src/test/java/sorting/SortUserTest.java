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
        SortUser sortUser = new SortUser();
        User user1 = new User("Pasha", 67);
        User user2 = new User("Sasha", 27);
        User user3 = new User("Lena", 31);
        Set<User> expected = Set.of(user1, user2, user3);
        Set<User> result = sortUser.sort(List.of(user1, user2, user3));
        assertThat(result, is(expected));
    }
    @Test
    public void whenSortedByNamesLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Pasha", 17);
        User user2 = new User("Sasha", 27);
        User user3 = new User("Lena", 31);
        Set<User> result = sortUser.sort(List.of(user1, user2, user3));
        assertThat(result.iterator().next().getName(), is("Pasha"));
    }
    @Test
    public void whenFirstSortedByNameThenByAge() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Pasha", 17));
        users.add(new User("Sasha", 27));
        users.add(new User("Lena", 31));
        List<User> result = sortUser.sortByAllFields(users);
        assertThat(result.iterator().next().getName(), is("Lena"));
    }
}