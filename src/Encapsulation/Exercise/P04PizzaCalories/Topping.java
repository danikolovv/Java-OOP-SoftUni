package Encapsulation.Exercise.P04PizzaCalories;

public class Topping {

    private static final double BASE_CALORIES_PER_GRAM = 2.0;
    private static final double MEAT_MODIFIER = 1.2;
    private static final double VEGGIES_MODIFIER = 0.8;
    private static final double CHEESE_MODIFIER = 1.1;
    private static final double SAUCE_MODIFIER = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") &&
                !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifier = 0;
        if (toppingType.equals("Meat")) {
            modifier = MEAT_MODIFIER;
        } else if (toppingType.equals("Veggies")) {
            modifier = VEGGIES_MODIFIER;
        } else if (toppingType.equals("Cheese")) {
            modifier = CHEESE_MODIFIER;
        } else if (toppingType.equals("Sauce")) {
            modifier = SAUCE_MODIFIER;
        }

        return BASE_CALORIES_PER_GRAM * weight * modifier;
    }
}
