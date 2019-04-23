package stream.school;

import java.util.Objects;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 18.04.2019
 */
public class Student {
    private int score;
    private String name;

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(name, student.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }
}