package ru.job4j.condition;
/**
 * @author Alexander Kashkin
 * @since 08.03.2019
 * @version 2
 */
public class Point {
    /**
     * @param x1 x1
     * @param x2 x2
     * @param y1 y1
     * @param y2 y2
     * @return distance
     */
    public double distance(int x1, int x2, int y1, int y2) {
        double result = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return result;
    }
}