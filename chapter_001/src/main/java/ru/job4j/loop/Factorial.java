package ru.job4j.loop;

/**
 * Calculator of factorial from one to infinity
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 03.01.2019
 */
public class Factorial {
    /**
     *
     * @param n - from 1 to infinity
     * @return - factorial
     */
    public int calculateFactorial(int n) {
        int fact = 1;
        for (int x = 1; x <= n; x++) {
            fact = fact * x;
        }
        return fact;
    }
}