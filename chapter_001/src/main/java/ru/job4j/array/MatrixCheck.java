package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @version 1
 * @since 12.03.2019
 */
public class MatrixCheck {
    /**
     * @param data - array
     * @return - result
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
                if (data[i][i] != data[i + 1][i + 1]
                || data[i][data.length - 1 - i] != data[i + 1][data.length - 2 - i]) {
                    result = false;
                    break;
            }
        }
        return result;
    }
}