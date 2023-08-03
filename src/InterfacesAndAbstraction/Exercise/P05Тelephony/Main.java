package InterfacesAndAbstraction.Exercise.P05Тelephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        String[] urlsToVisit = scanner.nextLine().split("\\s+");

        List<String> numbers = Arrays.asList(phoneNumbers);
        List<String> urls = Arrays.asList(urlsToVisit);

        Smartphone smartphone = new Smartphone(numbers, urls);

        String callOutput = smartphone.call();
        String browseOutput = smartphone.browse();

        System.out.print(callOutput);
        System.out.print(browseOutput);
    }
}
