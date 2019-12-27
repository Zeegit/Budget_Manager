package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class BudgetInterface {
    private Scanner scanner;
    private PurchaseList list;
    private String fileName;

    public BudgetInterface() {
        scanner = new Scanner(System.in);
        list = new PurchaseList();
        fileName = "purchases.txt";


    }

    public void start() {
        boolean gotoExit = false;
        while (!gotoExit) {
            int action = ChooseAction();
            switch (action) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    selectPurchase();
                    break;
                case 3:
                    showPurchases();
                    break;
                case 4:
                    showBalance();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFormFile();
                    break;
                case 0:
                    gotoExit = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Bye!");
    }

    private void loadFormFile() {
        list.loadFormFile(fileName);
        System.out.println("Purchases were loaded!");
        System.out.println();
    }

    private void saveToFile() {
        list.saveToFile(fileName);
        System.out.println("Purchases were saved!");
        System.out.println();
    }

    private int ChooseAction() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("0) Exit");
        int action = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return action;
    }

    private void addIncome() {
        System.out.println("Enter income:");
        double income = Double.parseDouble(scanner.nextLine());
        list.setBalance(income);
        System.out.println("Income was added!");
        System.out.println();
    }

    private int ChooseCategory() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
        int action = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return action;
    }

    private int ChooseCategoryAndAll() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
        int action = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return action;
    }

    private void addPurchase(Category category) {
        System.out.println("Enter purchase name:");
        String name = scanner.nextLine();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(scanner.nextLine());
        list.addPurchase(category, name, price);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    private void selectPurchase() {
        boolean gotoExit = false;
        while (!gotoExit) {
            int action = ChooseCategory();
            switch (action) {
                case 1:
                    addPurchase(Category.FOOD);
                    break;
                case 2:
                    addPurchase(Category.CLOTHES);
                    break;
                case 3:
                    addPurchase(Category.ENTERTAIMENT);
                    break;
                case 4:
                    addPurchase(Category.OTHER);
                    break;
                case 5:
                    gotoExit = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println();
    }

    private void showPurchases() {
        if (!list.isEmpty()) {
            boolean gotoExit = false;
            while (!gotoExit) {
                int action = ChooseCategoryAndAll();
                switch (action) {
                    case 1:
                        System.out.println("Food");
                        showPurchasesByCategory(new Category[] {Category.FOOD});
                        break;
                    case 2:
                        System.out.println("Clothes");
                        showPurchasesByCategory(new Category[] {Category.CLOTHES});
                        break;
                    case 3:
                        System.out.println("Entertainment");
                        showPurchasesByCategory(new Category[] {Category.ENTERTAIMENT});
                        break;
                    case 4:
                        System.out.println("Other");
                        showPurchasesByCategory(new Category[] {Category.OTHER});
                        break;
                    case 5:
                        System.out.println("All");
                        showPurchasesByCategory(new Category[] {Category.FOOD, Category.CLOTHES, Category.ENTERTAIMENT, Category.OTHER});
                        break;
                    case 6:
                        gotoExit = true;
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("Purchase list is empty");
        }
        System.out.println();
    }

    private void showPurchasesByCategory(Category[] cats) {
        double total = 0.0;
        if (!list.isEmpty() && list.existsOperationByCategories(cats)) {
            for (Purchase p : list.getPurchaseByCategories(cats)) {
                System.out.println(String.format("%s $%.2f", p.getName() , p.getPrice()));
                total += p.getPrice();
            }
            System.out.println(String.format("Total sum: $%.2f", total));
        } else {
            System.out.println("Purchase list is empty!");
        }
        System.out.println();
    }

    private void showBalance() {
        System.out.println(String.format("Balance: $%.2f", list.getBalance()));
        System.out.println();
    }
}

