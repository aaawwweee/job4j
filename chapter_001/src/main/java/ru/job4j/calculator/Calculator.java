package ru.job4j.calculator;
/**
 * @author Alexander Kashkin
 * @since 07.02.2019
 * @version 1
 */
public class Calculator {
    /**
     *
     * @param first first
     * @param second second
     * @return first plus second
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     *
     * @param first - first
     * @param second - second
     * @return first minus second
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     *
     * @param first - first
     * @param second - second
     * @return fisrt div second
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     *
     * @param first - fisrt
     * @param second - second
     * @return first mult second
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}
