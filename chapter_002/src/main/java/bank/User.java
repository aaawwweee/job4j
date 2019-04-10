package bank;
import java.util.Objects;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 10.04.2019
 * @version 1
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    public User(String passport) {
        this.passport = passport;
    }
    public String getName() {
        return name;
    }
    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return passport == user.passport
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}
