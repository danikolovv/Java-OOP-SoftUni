package Polymorphism.Exercise.P02VehiclesExtension;

public class Bus extends VehicleImpl {
    private boolean hasPeople;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        hasPeople = false;
    }

    protected void setHasPeople(boolean hasPeople) {
        this.hasPeople = hasPeople;
    }

    @Override
    protected void drive(double distance) {
        double fuelConsumed = hasPeople ? getFuelConsumption() + 1.4 : getFuelConsumption();
        double fuelNeeded = distance * fuelConsumed;
        if (fuelNeeded <= getFuelQuantity()) {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            System.out.printf("Bus travelled %.2f km%n", distance);
        } else {
            System.out.println("Bus needs refueling");
        }
    }
}
