package pseudo;
/**
 * @author Alexander Kashkin
 * @since 18.03.2019
 * @version 1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+ + + +").append(nLine);
        pic.append("+ + + +").append(nLine);
        pic.append("+ + + +").append(nLine);
        pic.append("+ + + +");
        return pic.toString();
    }
}
