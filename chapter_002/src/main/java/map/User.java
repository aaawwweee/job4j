package map;
import java.util.Calendar;
import java.util.Objects;

/**
 * Class User
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 03.06.2019
 * @version 1
 */

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//проверяем равенство объекта самому себе
        if (o == null || getClass() != o.getClass()) return false; //проверяем, не равен ли он null, проверяем классы

        User user = (User) o;//проверили instance, теперь поля

        if (children != user.children) return false; //сравнение int
        if (name != null ? !name.equals(user.name) : user.name != null) return false; // сравнение ссылочных типов
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override // переопределил equals - > переопределил hashCode
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}