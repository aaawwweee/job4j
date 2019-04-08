package pseudo;
/**
 * @author Alexander Kashkin
 * @since 18.03.2019
 * @version 1
 */
public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  ^  ").append(NLINE);
        pic.append(" ^^^ ").append(NLINE);
        pic.append("^^^^^");
        return pic.toString();
    }
}
