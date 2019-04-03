package ListThenMap;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListThenMap() {
        User user = new User(123, "Sasha", "Moscow");
        User user1 = new User(1234, "Masha", "Samara");
        User user2 = new User(12345, "Pasha", "Novgorod");
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        Map<Integer, User> map = new HashMap<>();
        map.put(123, user);
        map.put(1234, user1);
        map.put(12345, user2);
        HashMap<Integer, User> result = userConvert.process(list);
        assertThat(result, is(map));
    }
}