package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 11.03.2019
 * @version 1
 */
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * @param prefix prefix
     * @return - boolean result
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index != value.length; index++) {
            if (data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}