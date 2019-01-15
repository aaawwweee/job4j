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
            for (int index1 = 0; index1 < data.length; index++){
                if (data[index1 + 1] != data[index1 + 2]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}