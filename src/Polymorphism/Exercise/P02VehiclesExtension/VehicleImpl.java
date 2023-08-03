package Polymorphism.Exercise.P02VehiclesExtension;

public class VehicleImpl{
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded <= fuelQuantity) {
            fuelQuantity -= fuelNeeded;
            System.out.printf("%s travelled %.2f km%n", this.getClass().getSimpleName(), distance);
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    protected void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (liters + fuelQuantity > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            fuelQuantity += liters;
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f", fuelQuantity);
    }
}
