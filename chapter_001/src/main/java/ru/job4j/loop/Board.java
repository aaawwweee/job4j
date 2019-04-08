package ru.job4j.loop;

/**
 * @author Alexander Kashkin
 * @since 09.03.2019
 * @version 2
 */
public class Board {
    /**
     *
     * @param width width
     * @param height height
     * @return result
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((j + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}