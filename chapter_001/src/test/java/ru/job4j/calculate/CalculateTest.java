package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Alexander Kashkin (kashkinmsk@gmail.com)
* @version 1
* @since 21.12.2018
*/
public class CalculateTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenThreeEchoPlusName() {
    String input = "Alexander Kashkin";
    String expect = "Echo, echo, echo : Alexander Kashkin"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}