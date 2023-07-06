package Examples.InterferationWithClasses;

import java.util.Scanner;

public class DemoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Person person = new Person(30, "Ivan");
//
//        person.setId(35);
//        person.setName("Gosho");
//        String name = person.getName();
//
//        System.out.println(person.getId());
//        System.out.println(name);

        Person person = new Person();

        int generatedID = 1;
        String readName = scanner.nextLine();
        while (!readName.isEmpty()) {

            person.setDatabase(generatedID++, readName);

            readName = scanner.nextLine();
        }

        person.getDatabase().forEach((integer, s) -> System.out.printf("User's ID: %d, Username: %s%n", integer, s));

    }
}
