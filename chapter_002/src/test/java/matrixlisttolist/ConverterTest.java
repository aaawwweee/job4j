package matrixlisttolist;

import java.util.*;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConverterTest {
    @Test
    public void whenListMatrixConvertToList() {
        Integer[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        List<Integer> result = new Converter().matrixIntToList(matrix);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertThat(result, is(Arrays.asList(expected)));
    }
}
