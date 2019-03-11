package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 11.03.2019
 * @version 1
 */
public class Check {
    /**
     * @param data - array
     * @return - result
     */
    public boolean mono(boolean[] data) {
        boolean rst = true;
        for (int i = 0; i != data.length - 1; i++) {
            if (data[i] != data[data.length - 1 - i]) {
                rst = false;
                break;
            }
        }
        return rst;
    }
}