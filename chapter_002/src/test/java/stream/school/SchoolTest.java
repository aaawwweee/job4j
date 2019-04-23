package stream.school;
import java.util.*;
import java.util.function.Predicate;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    static School school = new School();
    List<Student> students = List.of(new Student("Pasha", 30),
            new Student("Sasha", 50),
            new Student("Klasha", 10),
            new Student("Masha", 70),
            new Student("Dasha", 80),
            new Student("Misha", 100)
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
    @Test
    public void whenStudentsCollectToMap() {
        List<Student> list = new ArrayList<>();
        Student first = new Student("Ivan", 100);
        Student second = new Student("Lesha", 120);
        Student third = new Student("Masha", 90);
        Student fourth = new Student("Oleg", 65);
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivan", new Student("Ivan", 100));
        expected.put("Lesha", new Student("Lesha", 120));
        expected.put("Masha", new Student("Masha", 90));
        expected.put("Oleg", new Student("Oleg", 65));
        assertThat(new School().toMap(list), is(expected));
    }
}