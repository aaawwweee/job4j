package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Converter Test.
 * @author Alexander Kashkin (kashkinmsk@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class ConverterTest {
    /**
     * Ruble to euro
     */
    @Test
    public void when69RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(69);
        assertThat(result, is(1));
    }

    /**
     * Ruble to euro
     */
    @Test
    public void when80RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(80);
        assertThat(result, is(1));
    }

    /**
     * Dollar to ruble
     */
    @Test
    public void when1DollarToRubleThen69() {
        Converter converter = new Converter ();
        int result = converter.dollarToRuble(1);
        assertThat(result, is (69));
    }

    /**
     * Euro to ruble
     */
    @Test
    public void when1EuroToRubleThen80() {
        Converter converter = new Converter ();
        int result = converter.euroToRuble(1);
        assertThat(result, is(80));
    }
}