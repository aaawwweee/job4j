package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 10.03.2019
 * @version 2
 */
public class FindLoop {
    /**
     * @param data - array
     * @param el - value
     * @return - result
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
