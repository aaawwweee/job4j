package students;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 24.04.2019
 * @version 1
 */
public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student() {
    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
    public String getName() {
        return name;
    }
    public int getScope() {
        return scope;
    }
    @Override
    public int compare(Student s1, Student s2) {
        int rez;
        if (s1 == null && s2 == null) {
            rez = 0;
        } else if (s1 == null) {
            rez = 1;
        } else if (s2 == null) {
            rez = -1;
        } else {
            rez = Integer.compare(s2.getScope(), s1.getScope());
        }
        return rez;
    }
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(new Student())
                .flatMap(Stream::ofNullable)
                .takeWhile(s -> s.getScope() > bound)
                .collect(Collectors.toList());
    }
}