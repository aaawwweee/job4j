package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void Factorialfrom5Then120() {
        Factorial fact = new Factorial();
        int result = fact.calculateFactorial(5);
        int expect = 120;
        assertThat(result, is(expect));
    }
    @Test
    public void Factorialfrom0then1() {
        Factorial fact = new Factorial();
        int result = fact.calculateFactorial(0);
        int expect = 1;
        assertThat(result, is(expect));
    }
}