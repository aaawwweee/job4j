package testtask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 24.06.2019
 */
public class Analyze {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> map = new HashMap<>();
        for (User user : current) {
            map.put(user.id, user);
        }
        for (User user1 : previous) {
            if (!map.containsKey(user1.id)) {
                info.deleted++;
            }
            User newUser = map.get(user1.id);
                if (newUser != null && !newUser.equals(user1)) {
                    info.changed++;
                }
            info.added = current.size() - previous.size() + info.deleted;
            }
            return info;
        }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (id != user.id) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}