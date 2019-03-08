package ru.job4j.condition;
/**
 * @author Alexander Kashkin
 * @version 2
 * @since 08.03.2019
 */
public class Triangle {
    /**
     * @param a distance between a b
     * @param b distance between a c
     * @param c distance between b c
     * @return p
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }
    /**
     * @param x1 x1
     * @param x2 x2
     * @param y1 y1
     * @param y2 u2
     * @param x3 x3
     * @param y3 y3
     * @return area
     */
    public double area(int x1, int x2, int y1, int y2, int x3, int y3) {
        Point point = new Point();
        double rst = -1;
        double a = point.distance(x1, y1, x2, y2);
        double b = point.distance(x2, y2, x3, y3);
        double c = point.distance(x1, y1, x3, y3);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rst = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rst;
    }
    /**
     * @param a side a
     * @param b side b
     * @param c side c
     * @return result
     */
    private boolean exist(double a, double b, double c) {
        boolean result = false;
        if ((a + c > b) && (a + b > c) && (c + b > a)) {
            result = true;
        }
        return result;
    }
}