package ru.job4j.loop;

/**
 * Board
 * @author Alexander Kashkin
 * @since 04.01.2019
 * @version 1
 */
public class Board {
    /**
     *
     * @param width - width of the table
     * @param height - height of the table
     * @return - table chess with painted X and " "
     */
    public String paint (int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0;i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
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