package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int q;
        for (int i = 0; i < bound; i++) {
            q = i +1;
            rst[i] = q * q;
        }
        return  rst;
    }
}