package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 11.03.2019
 * @version 2
 */
public class Turn {
    /**
     *
     * @param array - array
     * @return new array
     */
    public int[] back(int[] array) {
        for (int index = 0; index != array.length / 2; index++) {
            int x = array[array.length - index - 1];
            array[array.length - index - 1] = array[index];
            array[index] = x;
        }
        return array;
    }
}