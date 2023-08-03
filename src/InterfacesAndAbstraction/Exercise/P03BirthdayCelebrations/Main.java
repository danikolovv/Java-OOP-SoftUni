package InterfacesAndAbstraction.Exercise.P03BirthdayCelebrations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];

            if ("Citizen".equals(type)) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                birthables.add(citizen);
            } else if ("Pet".equals(type)) {
                String name = tokens[1];
                String birthDate = tokens[2];
                Pet pet = new Pet(name, birthDate);
                birthables.add(pet);
            } else if ("Robot".equals(type)) {
                String model = tokens[1];
                String id = tokens[2];
                Robot robot = new Robot(model, id);
            }
        }

        int yearToFilter = Integer.parseInt(scanner.nextLine());
        birthables.stream()
                .filter(birthable -> birthable.getBirthDate().endsWith("/" + yearToFilter))
                .forEach(birthable -> System.out.println(birthable.getBirthDate()));
    }
}
