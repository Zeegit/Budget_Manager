package budget;

import java.util.Scanner;
import java.util.ArrayList;

public class BudgetManager {
    private Scanner scanner;
    private ArrayList<String> operationName;
    private ArrayList<Double> operationSum;
    Double balance;

    public BudgetManager() {
        scanner = new Scanner(System.in);
        operationName = new ArrayList<>();
        operationSum = new ArrayList<>();
        balance = 0.0;
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
                    addPurchase();
                    break;
                case 3:
                    showPurchases();
                    break;
                case 4:
                    showBalance();
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

    private int ChooseAction() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
        int action = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return action;
    }

    private void addIncome() {
        System.out.println("Enter income:");
        double income = Double.parseDouble(scanner.nextLine());
        balance += income;
        System.out.println("Income was added!");
        System.out.println();
    }

    private void addPurchase() {
        System.out.println("Enter purchase name:");
        operationName.add(scanner.nextLine());
        System.out.println("Enter its price:");
        double price = Double.parseDouble(scanner.nextLine());
        operationSum.add(price);
        balance -= price;
        System.out.println("Purchase was added!");
        System.out.println();

    }
    private void showPurchases() {
        Double total = 0.0;
        if (operationName.size() != 0) {
            for (int i = 0; i < operationName.size(); i++) {
                System.out.println(operationName.get(i) + " $" + operationSum.get(i));
                total += operationSum.get(i);
            }
            System.out.println("Total sum: $"+total);
        }
        else {
            System.out.println("Purchase list is empty");
        }
        System.out.println();

    }

    private void showBalance() {
        System.out.println("Balance: $"+balance);
        System.out.println();
    }
}
