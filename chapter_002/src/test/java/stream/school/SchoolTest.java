package stream.school;
import java.util.*;
import java.util.function.Predicate;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    static School school = new School();
    List<Student> students = List.of(new Student(30),
            new Student(50),
            new Student(10),
            new Student(70),
            new Student(80),
            new Student(100)
    );

    @Test
    public void whenFilterToClassA() {
        Predicate<Student> isA = (student -> student.getScore() >= 70 & student.getScore() <= 100);
        List<Student> result = school.collect(students, isA);
        List expected = List.of(students.get(3), students.get(4), students.get(5));
        assertThat(result, is(expected));
    }
    @Test
    public void whenFilterToClassC() {
        Predicate<Student> isA = (student -> student.getScore() > 0 & student.getScore() < 50);
        List<Student> result = school.collect(students, isA);
        List expected = List.of(students.get(0), students.get(2));
        assertThat(result, is(expected));
    }
    @Test
    public void whenFilterToClassB() {
        Predicate<Student> isA = (student -> student.getScore() >= 50 & student.getScore() < 70);
        List<Student> result = school.collect(students, isA);
        List expected = List.of(students.get(1));
        assertThat(result, is(expected));
    }
}