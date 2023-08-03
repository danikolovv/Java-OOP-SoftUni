package Polymorphism.Exercise.P01Vehicles;

public class Car {
    private double fuelQuantity;
    private double fuelConsumption;
    private static final double SUMMER_FUEL_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption + SUMMER_FUEL_INCREASE;
    }

    public boolean drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            return true;
        }
        return false;
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.fuelQuantity);
    }
}
