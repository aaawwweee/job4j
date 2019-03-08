package ru.job4j.converter;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void when60RublesThen1Dollar() {
        Converter conv = new Converter();
        int rst = conv.rubleToDollar(60);
        assertThat(rst, is(1));
    }
    @Test
    public void when1DollarThen60Rubles() {
        Converter conv = new Converter();
        int rst = conv.dollarToRuble(1);
        assertThat(rst, is(60));
    }
    @Test
    public void when70RublesThen1Euro() {
        Converter conv = new Converter();
        int rst = conv.rubleToEuro(70);
        assertThat(rst, is(1));
    }
    @Test
    public void when1EuroThen70Rubles() {
        Converter conv = new Converter();
        int rst = conv.euroToRuble(1);
        assertThat(rst, is(70));
    }
}