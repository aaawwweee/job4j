package sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Alexander Kashkin
 * @since 04.04.2019
 * @version 1
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>();
        for(User value : list) {
            set.add(value);
        }
        return set;
    }
}
