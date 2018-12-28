package ru.job4j.calculator;

/**
 * The simplest Calculator
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 28.12.2018
 */
public class Calculator {
    private double result;

    /**
     * Add
     * @param first - first
     * @param second - second
     */

    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Div
     * @param first - first
     * @param second - second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Subtract
     * @param first - first
     * @param second - second
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Multiple
     * @param first - first
     * @param second - second
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * getResult
     * @return - result
     */
    public double getResult() {
        return this.result;
    }
}

