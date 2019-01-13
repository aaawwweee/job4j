package ru.job4j.array;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 13.01.2019
 */
public class Check {
    /**
     *
     * @param data - array
     * @return - result
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length - 1; index++ ) {
            if (data [index] == data[index + 1]) {
                result = true;
            }else{
                result = false;
            }
        }
        return result;
    }
}