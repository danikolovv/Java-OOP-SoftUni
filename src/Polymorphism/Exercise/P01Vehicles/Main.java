package Polymorphism.Exercise.P01Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);

        Car car = new Car(carFuelQuantity, carFuelConsumption);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int n = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.##");

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String action = command[0];
            String vehicle = command[1];
            double distanceOrFuel = Double.parseDouble(command[2]);

            switch (action) {
                case "Drive":
                    if (vehicle.equals("Car")) {
                        if (car.drive(distanceOrFuel)) {
                            System.out.println(String.format("Car travelled %s km", df.format(distanceOrFuel)));
                        } else {
                            System.out.println("Car needs refueling");
                        }
                    } else if (vehicle.equals("Truck")) {
                        if (truck.drive(distanceOrFuel)) {
                            System.out.println(String.format("Truck travelled %s km", df.format(distanceOrFuel)));
                        } else {
                            System.out.println("Truck needs refueling");
                        }
                    }
                    break;
                case "Refuel":
                    if (vehicle.equals("Car")) {
                        car.refuel(distanceOrFuel);
                    } else if (vehicle.equals("Truck")) {
                        truck.refuel(distanceOrFuel);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
