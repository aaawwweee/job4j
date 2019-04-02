package ArrayList;
import java.util.List;

/**
 * @author Alexander KAshkin
 * @since 02.04.2019
 * @version 1
**/

public class ConvertList2Array {
    public int[][] toArray (List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int row = 0; row != rows; row++) {
            for (int cell = 0; cell != cells; cell++) {
                array[row][cell] = index >= list.size() ? 0 : list.get(index++);
            }
        }
        return array;
    }
}
