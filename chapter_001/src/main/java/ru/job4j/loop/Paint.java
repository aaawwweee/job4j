package ru.job4j.loop;
import java.util.function.BiPredicate;

/**
 * Triangle (with refactoring)
 * @author Alexander Kashkin (kashkinmsk@gmail.com).
 * @version 2.
 * @since 04.01.2019.
 */
public class Paint {
    /**
     * @param height - height of our right triangle
     * @return - painted right triangle
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * @param height - height of our left triangle
     * @return - painted left triangle
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * @param height - height of our whole triangle
     * @return - painted triangle
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}