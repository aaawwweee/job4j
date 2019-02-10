package ptss;

public class Square implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+ + + +");
        pic.append("+ + + +");
        pic.append("+ + + +");
        pic.append("+ + + +");
        return pic.toString();
    }
}
