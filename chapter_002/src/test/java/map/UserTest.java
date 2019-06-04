package map;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenAddUsersToMapAndPrint() {
        Calendar dateBirth = new GregorianCalendar(1996, Calendar.JULY, 22);
        User user1 = new User("Sanya", 2, dateBirth);
        User user2 = new User("Sanya", 2, dateBirth);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
    }
}
