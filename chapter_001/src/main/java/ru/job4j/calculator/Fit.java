package ru.job4j.calculator;
/**
 * @author Alexander Kashkin
 * @version 2
 * @since 08.03.2019
 */
public class Fit {
    /**
     * @param height man
     * @return ideal weight
     */
    public double manWeight(double height) {
        return (height - 100.0) * 1.15;
    }
    /**
     * @param height woman
     * @return ideal weight
     */
    public double womanWeight(double height) {
        return (height - 110.0) * 1.15;
    }
}