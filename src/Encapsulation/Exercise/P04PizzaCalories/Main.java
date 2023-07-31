package Encapsulation.Exercise.P04PizzaCalories;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String pizzaInput = scanner.nextLine();
            String[] pizzaInfo = pizzaInput.split(" ");
            String pizzaName = pizzaInfo[1];
            int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

            // Create the pizza
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String doughInput = scanner.nextLine();
            String[] doughInfo = doughInput.split(" ");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double doughWeight = Double.parseDouble(doughInfo[3]);

            // Set the dough for the pizza
            pizza.setDough(new Dough(flourType, bakingTechnique, doughWeight));

            for (int i = 0; i < numberOfToppings; i++) {
                String toppingInput = scanner.nextLine();
                String[] toppingInfo = toppingInput.split(" ");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                // Add topping to the pizza
                pizza.addTopping(new Topping(toppingType, toppingWeight));
            }

            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(pizza.getName() + " - " + df.format(pizza.getOverallCalories()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
