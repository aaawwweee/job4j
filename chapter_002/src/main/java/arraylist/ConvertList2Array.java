package arraylist;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander KAshkin
 * @since 02.04.2019
 * @version 1
**/

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int temp : list) {
            array[i][j] = temp;
            if (j < cells - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        return array;
    }
    public List<Integer> convert(List<int[]> list) {
        List<Integer> iList = new ArrayList<>();
        for (int[] array : list) {
            for (int element : array) {
                iList.add(element);
            }

        }
        return iList;
    }
}
