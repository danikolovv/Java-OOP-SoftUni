package Encapsulation.Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            String message = String.format("%s can't afford %s", this.getName(), product.getName());
            throw new IllegalArgumentException(message);
        }
        this.money = this.getMoney() - product.getCost();
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (this.products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            List<String> productNames = new ArrayList<>();
            for (Product product : this.products) {
                productNames.add(product.getName());
            }
            sb.append(String.join(", ", productNames));
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
}
