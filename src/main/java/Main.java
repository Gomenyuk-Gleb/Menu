
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Functional functional = new Functional();
        functional.printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What you wont?");
            String answer = scanner.nextLine();
            switch (answer){
                case "1":
                    System.out.println(functional.allMenu());
                    break;
                case "2":
                    System.out.println(functional.productsOnlySale());
                case "3":
                    System.out.println("Suma ot ");
                    int from = scanner.nextInt();
                    System.out.println("Suma do ");
                    int befor = scanner.nextInt();
                    System.out.println(functional.saleMenuscostFromAndTo(from, befor));
                case "4":
                    System.out.println(functional.choiceOfDishesWeightOneKG());
            }

        }

    }
}
