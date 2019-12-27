package budget;

public class Balance {
    private double balance;

    public Balance() {
        this.balance = 0.0;
    }

    public Balance(double balance) {
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void add(double sum) {
        this.balance += balance;
    }

    public void sub(double sum) {
        this.balance -= balance;
    }
}
