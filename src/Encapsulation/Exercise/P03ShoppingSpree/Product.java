package Encapsulation.Exercise.P03ShoppingSpree;

public class Product {

    private String name;
    private Double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
}
