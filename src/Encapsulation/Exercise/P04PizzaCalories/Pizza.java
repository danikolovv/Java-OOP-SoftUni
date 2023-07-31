package Encapsulation.Exercise.P04PizzaCalories;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.toppings = new ArrayList<>();
        this.setToppings(numberOfToppings);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalCalories = dough.calculateCalories();
        for (Topping topping : toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return name + " - " + df.format(getOverallCalories());
    }

}
