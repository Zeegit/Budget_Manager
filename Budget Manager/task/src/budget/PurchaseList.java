package budget;

import java.util.ArrayList;

public class PurchaseList {
    private ArrayList<Purchase> operations;
    Balance balance;

    public PurchaseList() {
        operations =  new ArrayList<>();
        balance =  new Balance();
    }

    public void addPurchase(Category category, String name, double price) {
        operations.add(new Purchase(category, name, price));
        balance.sub(price);
    }

    void setBalance(double balance) {
        this.balance.setBalance(balance);
    }

    public double getBalance() {
        return balance.getBalance();
    }

    boolean isEmpty() {
        return operations.isEmpty();
    }

    ArrayList<Purchase> getPurchaseByCategories(Category[] categories) {
        ArrayList<Purchase> p = new ArrayList<Purchase>();
        for(Purchase pu : operations) {
            for(Category ca : categories) {
                if (pu.getСategory() == ca) {
                    p.add(pu);
                }
            }
        }
        return p;
    }

    boolean existsOperationByCategories (Category[] categories) {
        boolean p = false;
        for(Purchase pu : operations) {
            for(Category ca : categories) {
                if (pu.getСategory() == ca) {
                    p = true;
                    break;
                }
            }
        }
        return p;
    }
}
