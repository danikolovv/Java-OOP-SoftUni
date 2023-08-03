package Polymorphism.Exercise.P02VehiclesExtension;

public class Truck extends VehicleImpl {
    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
