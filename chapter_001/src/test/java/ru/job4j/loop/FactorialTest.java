package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void Factorialfrom5Then120(){
        Factorial fact = new Factorial ();
        int result = fact.calculateFactorial(5);
        int expect = 120;
        assertThat(result,is (expect));
        }

    }