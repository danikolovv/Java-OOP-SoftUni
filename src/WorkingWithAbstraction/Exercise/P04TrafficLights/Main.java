package WorkingWithAbstraction.Exercise.P04TrafficLights;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Signals[] arrayColors = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Signals::valueOf)
                                      .toArray(Signals[]::new);

        Signals[] signals = Signals.values();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            
        }
    }
}
