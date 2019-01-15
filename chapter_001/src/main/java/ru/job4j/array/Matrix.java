package ru.job4j.array;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com).
 * @version 1
 * @since 15.01.2019
 */
public class Matrix {
    /**
     *
     * @param size - size
     * @return - table
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}