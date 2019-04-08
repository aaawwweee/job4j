package ru.job4j.array;
/**
 * @author Alexander Kashkin
 * @since 10.03.2019
 * @version 2
 */
public class Square {
    /**
     *
     * @param bound - array's length
     * @return - index*index array
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index != bound; index++) {
            rst[index] = (index + 1) * (index + 1);
        }
        return rst;
    }
}