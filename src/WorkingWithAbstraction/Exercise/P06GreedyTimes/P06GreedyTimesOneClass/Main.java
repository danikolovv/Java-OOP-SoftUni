package WorkingWithAbstraction.Exercise.P06GreedyTimes.P06GreedyTimesOneClass;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] vaultItems = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        long goldCount = 0;
        long gemCount = 0;
        long cashCount = 0;

        for (int i = 0; i < vaultItems.length; i += 2) {
            String item = vaultItems[i];
            long quantity = Long.parseLong(vaultItems[i + 1]);

            String itemType = getItemType(item);

            if (itemType.isEmpty() || exceedsCapacity(capacity, bag, quantity)) {
                continue;
            }

            if (!canAddToBag(bag, itemType, quantity)) {
                continue;
            }

            updateBag(bag, itemType, item, quantity);
            updateItemCount(itemType, quantity);
        }

        printBagContents(bag);
    }

    private static String getItemType(String item) {
        if (item.length() == 3) {
            return "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (item.toLowerCase().equals("gold")) {
            return "Gold";
        }
        return "";
    }

    private static boolean exceedsCapacity(long capacity, Map<String, Map<String, Long>> bag, long quantity) {
        return capacity < bag.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .mapToLong(Long::longValue)
                .sum() + quantity;
    }

    private static boolean canAddToBag(Map<String, Map<String, Long>> bag, String itemType, long quantity) {
        switch (itemType) {
            case "Gem":
                if (!bag.containsKey(itemType)) {
                    if (bag.containsKey("Gold")) {
                        return quantity <= bag.get("Gold").values().stream()
                                .mapToLong(Long::longValue)
                                .sum();
                    } else {
                        return false;
                    }
                } else {
                    return bag.get(itemType).values().stream()
                            .mapToLong(Long::longValue)
                            .sum() + quantity <= bag.get("Gold").values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                }
            case "Cash":
                if (!bag.containsKey(itemType)) {
                    if (bag.containsKey("Gem")) {
                        return quantity <= bag.get("Gold").values().stream()
                                .mapToLong(Long::longValue)
                                .sum();
                    } else {
                        return false;
                    }
                } else {
                    return bag.get(itemType).values().stream()
                            .mapToLong(Long::longValue)
                            .sum() + quantity <= bag.get("Gem").values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                }
        }
        return true;
    }

    private static void updateBag(Map<String, Map<String, Long>> bag, String itemType, String item, long quantity) {
        bag.putIfAbsent(itemType, new LinkedHashMap<>());
        bag.get(itemType).putIfAbsent(item, 0L);
        bag.get(itemType).put(item, bag.get(itemType).get(item) + quantity);
    }

    private static void updateItemCount(String itemType, long quantity) {
        switch (itemType) {
            case "Gold":
                goldCount += quantity;
                break;
            case "Gem":
                gemCount += quantity;
                break;
            case "Cash":
                cashCount += quantity;
                break;
        }
    }

    private static void printBagContents(Map<String, Map<String, Long>> bag) {
        for (var entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream()
                    .mapToLong(Long::longValue)
                    .sum();

            System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));

            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(item -> System.out.println("##" + item.getKey() + " - " + item.getValue()));
        }
    }

    private static long goldCount = 0;
    private static long gemCount = 0;
    private static long cashCount = 0;
}
