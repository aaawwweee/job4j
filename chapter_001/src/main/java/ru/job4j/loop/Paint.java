package ru.job4j.loop;

/**
 * Triangle
 * @author Alexander Kashkin (kashkinmsk@gmail.com).
 * @version 1.
 * @since 04.01.2019.
 */
public class Paint {
    /**
     * @param height - height of our right triangle
     * @return - painted right triangle
     */
    public String rightTrl(int height){
        //Буфер для результата
        StringBuilder screen = new StringBuilder();
        //ширина будет равно высоте.
        int weight = height;
        //внешний цикл двигается по строкам
        for (int row = 0; row !=height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight;column++){
                //если строка равна ячейки, то риусем галку.
                //в данном случае случае строка определяет, сколько галок будет на строке
                if (row >= column) {
                    screen.append("^");
                }else {
                    screen.append(" ");
                }
                }
            //добавляем перевод строки.
            screen.append(System.lineSeparator());
            }
        //получаем результат.
        return screen.toString();
        }
    public String leftTrl(int height) {
        /**
         * @param height - height of our left triangle
         * @return - painted left triangle
         */
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    public String pyramid(int height) {
        /**
         * @param height - height of our whole triangle
         * @return - painted triangle
         */
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    }