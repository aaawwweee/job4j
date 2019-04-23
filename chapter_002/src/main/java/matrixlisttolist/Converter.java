package matrixlisttolist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 23.04.2019
 */
public class Converter {
    public List<Integer> matrixIntToList(Integer[][] data) {
        return Stream.of(data).flatMap(Stream::of).collect(Collectors.toList());
    }
}
