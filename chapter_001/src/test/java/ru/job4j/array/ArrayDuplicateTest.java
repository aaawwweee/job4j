package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {
    @Test
    public void whenArrayHasDuplicatesThenDropIt() {
        String[] input = {"Moscow", "Novgorod", "Moscow", "New-York", "Minsk"};
        String[] except = {"Moscow", "Novgorod", "New-York", "Minsk"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));

    }
}