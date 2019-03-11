package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 11.03.2019
 * @version 1
 */
public class BubbleSort {
    /**
     * @param array - array
     * @return - sorted array
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }
        return  array;
    }
}