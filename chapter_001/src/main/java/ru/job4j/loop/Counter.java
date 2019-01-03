package ru.job4j.loop;

/**
 * Simply counter
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 03.01.2018
 */
public class Counter {
    /**
     * @param start  - start
     * @param finish - finish
     * @return - summa chisel x%2 == 0
     */
    public int add(int start, int finish) {
        int summa = 0;
        for (int x = start; x <= finish; x++) {
            if (x % 2 == 0) {
                summa = x + summa;
            }
        }
        return summa;
    }
}