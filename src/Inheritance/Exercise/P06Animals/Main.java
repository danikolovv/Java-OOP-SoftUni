package Inheritance.Exercise.P06Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        while (!(input = scanner.nextLine()).equals("Beast!")) {
            String[] animalInfo = scanner.nextLine().split("\\s+");
            try {
                Animal animal = createAnimal(input, animalInfo);
                printAnimalInfo(animal);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static Animal createAnimal(String type, String[] animalInfo) {
        String name = animalInfo[0];
        int age = Integer.parseInt(animalInfo[1]);
        String gender = animalInfo[2];
        switch (type) {
            case "Dog":
                return new Dog(name, age, gender);
            case "Cat":
                return new Cat(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }

    private static void printAnimalInfo(Animal animal) {
        System.out.println(animal.getClass().getSimpleName());
        System.out.println(animal.getName() + " " + animal.getAge() + " " + animal.getGender());
        System.out.println(animal.produceSound());
    }
}
