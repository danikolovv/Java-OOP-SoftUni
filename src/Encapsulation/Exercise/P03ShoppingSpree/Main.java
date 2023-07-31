package Encapsulation.Exercise.P03ShoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            Arrays.stream(scanner.nextLine().split(";"))
                  .forEach(p -> {
                      String[] tokens = p.split("=");
                      Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                      people.putIfAbsent(person.getName(), person);
                  });

            Arrays.stream(scanner.nextLine().split(";"))
                  .forEach(p -> {
                      String[] tokens = p.split("=");
                      Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                      products.putIfAbsent(product.getName(), product);
                  });

            String input = scanner.nextLine();
            while (!input.equals("END")) {
                String[] tokens = input.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];

                Person person = people.get(personName);
                Product product = products.get(productName);

                try {
                    person.buyProduct(product);
                    System.out.printf("%s bought %s%n", personName, productName);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

                input = scanner.nextLine();
            }

            // Print each person's bought products
            for (Person person : people.values()) {
                System.out.println(person);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
