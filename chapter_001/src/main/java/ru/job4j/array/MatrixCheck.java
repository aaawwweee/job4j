package ru.job4j.array;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 15.01.2019
 * @version 1
 */

public class MatrixCheck {
    /**
     *
     * @param data - array
     * @return - all elements diagonally true or false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 0; index < data.length; index++) {
                if (data[0][0] != data[index][index]) {
                    result = false;
                    break;
                }
                if (data[data.length - 1][data.length - 1] != data[data.length - 1 - index][data.length - 1 - index]) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}