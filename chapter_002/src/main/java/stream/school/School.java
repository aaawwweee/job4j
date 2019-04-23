package stream.school;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 18.04.2019
 */
public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
   }
   Map<String, Student> toMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getName,
                Student -> Student
        ));
   }
}