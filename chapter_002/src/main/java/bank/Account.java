package bank;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 10.04.2019
 * @version 1
 */
public class Account {
    private double value;
    private int requisites;

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public double getValue() {
        return value;
    }
    public int getRequisites() {
        return requisites;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }
}