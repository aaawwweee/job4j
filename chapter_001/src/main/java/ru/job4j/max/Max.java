package ru.job4j.max;

/**
 * Возвращение максимального числа из 2 и 3
 * @version 1
 * @author Alexander Kashkin
 * @since 01.01.2019
 */
public class Max {
    /**
     *
     * @param first - first
     * @param second - second
     * @return - max of 2
     */
    public int max(int first, int second){
        return (first > second) ? first : second;
    }

    /**
     *
     * @param first - first
     * @param second - second
     * @param third - third
     * @return - max of 3
     */
    public int max(int first, int second, int third) {
        return max(max (first, second), third);
}
}