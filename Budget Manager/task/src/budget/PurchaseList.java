package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<Purchase> p = new ArrayList<>();
        for(Purchase pu : operations) {
            for(Category ca : categories) {
                if (pu.getСategory() == ca) {
                    p.add(pu);
                }
            }
        }
        return p;
    }

    double getSumByCategories(Category[] categories) {
        double total = 0D;
        ArrayList<Purchase> p = new ArrayList<>();
        for(Purchase pu : operations) {
            for(Category ca : categories) {
                if (pu.getСategory() == ca) {
                    total += pu.getPrice();
                }
            }
        }
        return total;
    }

    double getSumByCategory(Category ca) {
        double total = 0D;
        ArrayList<Purchase> p = new ArrayList<>();
        for(Purchase pu : operations) {
            if (pu.getСategory() == ca) {
                total += pu.getPrice();
            }
        }
        return total;
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

    void saveToFile(String fileName) {
        File file = new File(fileName);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(getBalance());

            for (Purchase p : operations)  {
                printWriter.println(p.getСategory());
                printWriter.println(p.getName());
                printWriter.println(p.getPrice());
            }
        } catch (IOException e) {
            System.out.println("An exception occurs "+e.getMessage());
        }
    }

    void loadFormFile(String fileName) {
        File file = new File(fileName);
        try (Scanner scn = new Scanner(file)) {
            double bal = Double.parseDouble(scn.nextLine());
            balance.setBalance(bal);
            while (scn.hasNext()) {
                Category category = Category.valueOf(scn.nextLine());
                String name = scn.nextLine();
                double price = Double.parseDouble(scn.nextLine());
                operations.add(new Purchase(category, name, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


}
