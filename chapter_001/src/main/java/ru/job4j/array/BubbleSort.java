package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}