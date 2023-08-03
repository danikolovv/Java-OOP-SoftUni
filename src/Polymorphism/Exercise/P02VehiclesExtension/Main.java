package Polymorphism.Exercise.P02VehiclesExtension;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);
        double carTankCapacity = Double.parseDouble(carInfo[3]);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);
        double truckTankCapacity = Double.parseDouble(truckInfo[3]);

        String[] busInfo = scanner.nextLine().split("\\s+");
        double busFuelQuantity = Double.parseDouble(busInfo[1]);
        double busFuelConsumption = Double.parseDouble(busInfo[2]);
        double busTankCapacity = Double.parseDouble(busInfo[3]);

        Car car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);
        Bus bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);

        int n = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.##", new DecimalFormatSymbols());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String action = command[0];
            String vehicle = command[1];
            double distance = Double.parseDouble(command[2]);

            switch (action) {
                case "Drive":
                    if (vehicle.equals("Car")) {
                        car.drive(distance);
                    } else if (vehicle.equals("Truck")) {
                        truck.drive(distance);
                    } else if (vehicle.equals("Bus")) {
                        bus.drive(distance);
                    }
                    break;
                case "DriveEmpty":
                    if (vehicle.equals("Bus")) {
                        bus.setHasPeople(false);
                        bus.drive(distance);
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(command[2]);
                    if (vehicle.equals("Car")) {
                        car.refuel(liters);
                    } else if (vehicle.equals("Truck")) {
                        truck.refuel(liters);
                    } else if (vehicle.equals("Bus")) {
                        bus.refuel(liters);
                    }
                    break;
            }
        }

        System.out.println("Car: " + df.format(car.getFuelQuantity()));
        System.out.println("Truck: " + df.format(truck.getFuelQuantity()));
        System.out.println("Bus: " + df.format(bus.getFuelQuantity()));
    }
}
