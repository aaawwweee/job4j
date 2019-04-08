package coffeemachine;
import java.util.Arrays;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 30.03.2019
 * @version 1
 */
public class CoffeeMachine {
    private final static int[] NOMINAL = {10, 5, 2, 1};
    int[] changes(int value, int price) {
        int change = value - price;
        int[] result = new int[change];
        int counter = 0;
        for (int i = 0; i < NOMINAL.length;) {
            if (change / NOMINAL[i] >= 1) {
                for (int x = 0; x < change / NOMINAL[i]; x++) {
                    if (change - NOMINAL[i] >= 0) {
                        change -= NOMINAL[i];
                        result[counter] = NOMINAL[i];
                        counter++;
                    } else {
                        i++;
                    }
                }
            } else {
                i++;
            }
        }
        return Arrays.copyOf(result, counter);
    }
}