package ListThenMap;
import java.util.HashMap;
import java.util.List;
/**
 * @author Alexander Kashkin
 * @since 03.04.2019
 * @version 1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}