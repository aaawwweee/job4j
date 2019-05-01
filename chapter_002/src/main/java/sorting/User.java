package sorting;
/**
 * @author Alexander Kashkin
 * @since 04.04.2019
 * @version 1
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}