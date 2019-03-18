package pseudo;
/**
 * @author Alexander Kashkin
 * @since 18.03.2019
 * @version 1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        System.out.println(triangle.draw());
        System.out.println(square.draw());
    }
}
