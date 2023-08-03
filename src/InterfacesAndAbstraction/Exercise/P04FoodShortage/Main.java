package InterfacesAndAbstraction.Exercise.P04FoodShortage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> people = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (tokens.length == 4) {
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                people.put(name, citizen);
            } else if (tokens.length == 3) {
                String group = tokens[2];
                Rebel rebel = new Rebel(name, age, group);
                people.put(name, rebel);
            }
        }

        String buyerName = scanner.nextLine();
        while (!buyerName.equals("End")) {
            Buyer buyer = people.get(buyerName);
            if (buyer != null) {
                buyer.buyFood();
            }

            buyerName = scanner.nextLine();
        }

        int totalFood = people.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
