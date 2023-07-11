package InterfacesAndAbstraction.Lab.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableObjects = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] commands = command.split("\\s+");

            if (commands.length == 3) {
                String name = commands[0];
                int age = Integer.parseInt(commands[1]);
                String id = commands[2];
                Identifiable citizen = new Citizen(name, age, id);
                identifiableObjects.add(citizen);

            } else if (commands.length == 2){
                String model = commands[0];
                String id = commands[1];
                Identifiable robot = new Robot(model, id);
                identifiableObjects.add(robot);
            }

            command = scanner.nextLine();
        }

        String fakeIdSuffix = scanner.nextLine();

        identifiableObjects.stream()
                .filter(i -> i.getId().endsWith(fakeIdSuffix))
                .forEach(i -> System.out.println(i.getId()));
    }
}
