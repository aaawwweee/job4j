package ArrayList;
/**
 * @Alexander Kashkin
 * @since 02.04.2019
 * @version 1
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList (Integer[][] array) {
        List<Integer> list = new ArrayList<>();
        for (Integer[] i : array) {
            list.addAll(Arrays.asList(i));
        }
        return list;
    }
}
