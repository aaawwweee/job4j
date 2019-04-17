package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 17.04.2019
 * @version 1
 */
public class Lambds {
    public List<Double> diapason (int start, int end, Function<Double, Double> func) {
        List<Double> lists = new ArrayList<>();
        for (double index = start; index != end; index++) {
            lists.add(func.apply(index));

        }
        return lists;
    }
}