package Polymorphism.Exercise.P01Vehicles;

public class Truck {
    private double fuelQuantity;
    private double fuelConsumption;
    private static final double SUMMER_FUEL_INCREASE = 1.6;
    private static final double REFUEL_EFFICIENCY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
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
        this.fuelQuantity += liters * REFUEL_EFFICIENCY;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.fuelQuantity);
    }
}
