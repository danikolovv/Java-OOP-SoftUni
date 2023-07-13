package WorkingWithAbstraction.Exercise.P06GreedyTimes;

public class ItemAnalyzer {

    Bag bag = new Bag();
    public static String getItemType(String item) {
        if (item.length() == 3) {
            return "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (item.toLowerCase().equals("gold")) {
            return "Gold";
        }
        return "";
    }

    public static boolean exceedsCapacity(long capacity, Bag bag, long quantity) {
        long currentTotal = bag.getBag().values().stream()
                .flatMap(m -> m.values().stream())
                .mapToLong(Long::longValue)
                .sum();

        return capacity < currentTotal + quantity;
    }

    public static boolean canAddToBag(Bag bag, String itemType, long quantity) {
        switch (itemType) {
            case "Gem":
                if (!bag.getBag().containsKey(itemType)) {
                    if (bag.getBag().containsKey("Gold")) {
                        return quantity <= bag.getBag().get("Gold").values().stream()
                                .mapToLong(Long::longValue)
                                .sum();
                    } else {
                        return false;
                    }
                } else {
                    return bag.getBag().get(itemType).values().stream()
                            .mapToLong(Long::longValue)
                            .sum() + quantity <= bag.getBag().get("Gold").values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                }
            case "Cash":
                if (!bag.getBag().containsKey(itemType)) {
                    if (bag.getBag().containsKey("Gem")) {
                        return quantity <= bag.getBag().get("Gold").values().stream()
                                .mapToLong(Long::longValue)
                                .sum();
                    } else {
                        return false;
                    }
                } else {
                    return bag.getBag().get(itemType).values().stream()
                            .mapToLong(Long::longValue)
                            .sum() + quantity <= bag.getBag().get("Gem").values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                }
        }
        return true;
    }
}
