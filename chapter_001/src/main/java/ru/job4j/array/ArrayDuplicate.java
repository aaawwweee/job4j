package ru.job4j.array;
import java.util.Arrays;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 16.01.2019
 * @version 1
 */

public class ArrayDuplicate {
    /**
     * @param array - initial array
     * @return - array with no duplicates
     */
    String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}