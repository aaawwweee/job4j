package ru.job4j.converter;
/**
 * @author Alexander Kashkin
 * @since 07.02.2019
 * @verion 1
 */
public class Converter {
    /**
     * @param value rubles
     * @return - euro
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }
    /**
     * @param value - euro
     * @return rubles
     */
    public int euroToRuble(int value) {
        return value  * 70;
    }
    /**
     * @param value - dollar
     * @return rubles
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
    /**
     * @param value - rubles
     * @return dollars
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }
}