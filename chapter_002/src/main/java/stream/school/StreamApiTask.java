package stream.school;
import java.util.Arrays;
import java.util.List;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 14.05.2019
 * @version 1
 */
public class StreamApiTask {
    /**
     * Filter and sum value of array
     * @param array - array
     * @return Integer
     */
    public Integer streamMethod(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        return list.stream().filter(x -> x % 2 == 0).
                map(x -> x * x).reduce(0, (acc, x) -> acc + x);
    }
}