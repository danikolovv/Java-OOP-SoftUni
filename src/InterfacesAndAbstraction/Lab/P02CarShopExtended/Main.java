package InterfacesAndAbstraction.Lab.P02CarShopExtended;

public class Main {
    public static void main(String[] args) {
        Car seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Car audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        CarImpl carLeon = new CarImpl("Leon", "Gray", 110, "Spain");
        CarImpl carAudi = new CarImpl("A4", "Gray", 110, "Germany");

        printCarInfo(seat);
        System.out.println(carLeon.toString());
        printMoreInfo(seat);

        printCarInfo(audi);
        System.out.println(carAudi.toString());
        printMoreInfo(audi);

    }
    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
    }

    private static void printMoreInfo(Car car) {
        System.out.println(car.toString());
    }
}
