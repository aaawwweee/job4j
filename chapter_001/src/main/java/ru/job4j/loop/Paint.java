package ru.job4j.loop;
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
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int col = 0; col != width; col++) {
                if (row >= col) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     *
     * @param height - height
     * @return result
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int col = 0; col != width; col++) {
                if (row >= width - col - 1) {
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