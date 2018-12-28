package ru.job4j.calculator;

/**
 * Ideal weight calculation program.
 * @author Alexander Kashkin (kashkinmsk@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Fit {
    /**
     * Ideal weight for a man
     * @param height height.
     * @return ideal weight.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Ideal weight for a woman.
     * @param height height.
     * @return ideal weight.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
