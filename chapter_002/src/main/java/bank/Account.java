package bank;

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
