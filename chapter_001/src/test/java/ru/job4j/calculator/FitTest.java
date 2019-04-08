package ru.job4j.calculator;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.Test;

public class FitTest {
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(190);
        assertThat(weight, closeTo(103.5, 0.5));
    }
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(175);
        assertThat(weight, closeTo(74.75, 0.5));
    }
}