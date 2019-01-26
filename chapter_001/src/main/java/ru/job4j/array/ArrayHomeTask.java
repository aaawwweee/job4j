package ru.job4j.array;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 26.01.19
 * @version 1
 */

public class ArrayHomeTask {
    /**
     *
     * @param a the first sorted array
     * @param b the second sorted array
     * @return result - the third sorted array from first and second arrays
     */
    public int[] sort(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {
            if (i > a.length - 1) {
                int x = b[j];
                result[k] = x;
                j++;
            } else if (j > b.length - 1) {
                int x = a[i];
                result[k] = x;
                i++;
            } else if (a[i] < b [j]) {
                int x = a[i];
                result[k] = x;
                i++;
            } else {
                int x2 = b[j];
                result[k] = x2;
                j++;
            }
        }
        return result;
    }
}
