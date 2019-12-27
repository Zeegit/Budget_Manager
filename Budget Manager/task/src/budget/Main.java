package budget;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> l  = new ArrayList<>();

        while (scanner.hasNext()) {
            l.add(scanner.nextLine());
        }

        double sum = 0;
        for(String s: l) {
            System.out.println(s);
            sum += Double.parseDouble(s.substring(s.lastIndexOf('$')+1));
        }

        System.out.println("Total: $"+sum);

    }
}
