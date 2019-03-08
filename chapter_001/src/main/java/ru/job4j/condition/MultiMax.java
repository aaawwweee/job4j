package ru.job4j.condition;
/**
 * @author Alexander Kashkin
 * @version 2
 * @since 08.03.2019
 */
public class MultiMax {
    /**
     * @param first - first
     * @param second - second
     * @param third - third
     * @return max from first second third
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        result = result > third ? result : third;
        return result;
    }
}