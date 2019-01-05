package ru.job4j.array;

/**
 * Поиск элемента в массиве.
 * @author Alexander Kashkin.
 * @version 1.
 * @since 05.01.2019.
 */
public class FindLoop {
    /**
     *
     * @param data - массив
     * @param el - нужное число
     * @return - вернуть нужное число, если его нет, то -1
     */
    public int Index0f(int[] data, int el){
        int rst = -1;
        for (int index = 0; index < data.length; index++){
            if (data[index] == el){
                rst = index;
                break;
            }
        }
        return rst;
    }
}