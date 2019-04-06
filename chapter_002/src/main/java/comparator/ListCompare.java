package comparator;
import java.util.Comparator;

/**
 * @author Alexander Kashkin
 * @version 1
 * @since 06.04.2019
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = right.length() >= left.length() ? left.length() : right.length();
        for (int i = 0; i < length; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
            return result != 0 ? result : Integer.compare(left.length(), right.length());
    }
}