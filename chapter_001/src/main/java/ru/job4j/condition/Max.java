package ru.job4j.condition;
/**
 * @author Alexander Kashkin
 * @since 08.03.2019
 * @version 2
 */
public class Max {
    /**
     * @param left left
     * @param right right
     * @return max (left or right)
     */
    public int max(int left, int right) {
        int result = left < right ? right : left;
        return result;
    }
}
