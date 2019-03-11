package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 11.03.2019
 * @version 1
 */
public class Matrix {
    /**
     * @param size of the table
     * @return table
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (j + 1) * (i + 1);
            }
        }
        return table;
    }
}