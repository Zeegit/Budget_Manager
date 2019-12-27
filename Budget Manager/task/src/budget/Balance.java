package budget;

public class Balance {
    private double balance;

    public Balance() {
        this.balance = 0.0;
    }

    public Balance(double sum) {
        this.balance = sum;
    }

    public void setBalance(double sum) {
        this.balance = sum;
    }

    public double getBalance() {
        return this.balance;
    }

    public void add(double sum) {
        this.balance += sum;
    }

    public void sub(double sum) {
        this.balance -= sum;
    }
}
