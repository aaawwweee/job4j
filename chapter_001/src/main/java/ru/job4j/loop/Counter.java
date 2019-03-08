package ru.job4j.loop;
/**
 * @author Alexander Kashkin
 * @version 1
 * @since 08.03.2019
 */
public class Counter {
    /**
     *
     * @param start first
     * @param finish last
     * @return sum
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (start = 1; start <= finish; start++) {
            if (start % 2 == 0) {
                sum += start;
            }
        }
        return sum;
    }
}
