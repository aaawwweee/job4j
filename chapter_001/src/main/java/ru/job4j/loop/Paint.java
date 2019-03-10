package ru.job4j.loop;
import java.util.function.BiPredicate;
/**
 * @author Alexander Kashkin
 * @since 10.03.2019
 * @version 2
 */
public class Paint {
    /**
     *
     * @param height height
     * @return result
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, col) -> row >= col
        );
    }
    /**
     *
     * @param height - height
     * @return result
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    /**
     *
     * @param height - height
     * @param widht - height
     * @param predict - predict
     * @return - result
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
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