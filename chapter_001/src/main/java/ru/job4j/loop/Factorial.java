package ru.job4j.loop;
/**
 * @author Alexander Kashkin
 * @since 08.03.2019
 * @version 2
 */
public class Factorial {
    /**
     * @param n - n
     * @return factorial from n
     */
    public int calc(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
