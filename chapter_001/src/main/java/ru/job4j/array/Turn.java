package ru.job4j.array;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 13.01.2019
 */
public class Turn {
    /**
     *
     * @param b - array
     * @return - newArray
     */
    public int [] array(int [] b) {
        int temp;
        for (int i = 0; i < b.length/2; i++) {
            temp = b[i];
            b[i] = b[b.length - i - 1];
            b[b.length - i - 1] = temp;
        }
        return  b;
    }
}