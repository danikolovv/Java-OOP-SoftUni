package WorkingWithAbstraction.Exercise.P06GreedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private Map<String, Map<String, Long>> bag;
    private long goldCount;
    private long gemCount;
    private long cashCount;

    public Bag() {
        this.bag = new LinkedHashMap<>();
        this.goldCount = 0;
        this.gemCount = 0;
        this.cashCount = 0;
    }

    public Map<String, Map<String, Long>> getBag() {
        return bag;
    }

    public void updateBag(String itemType, String item, long quantity) {
        bag.putIfAbsent(itemType, new LinkedHashMap<>());
        bag.get(itemType).putIfAbsent(item, 0L);
        bag.get(itemType).put(item, bag.get(itemType).get(item) + quantity);
    }

    public void updateItemCount(String itemType, long quantity) {
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

    public void printBagContents() {
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

    public long getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(long goldCount) {
        this.goldCount = goldCount;
    }

    public long getGemCount() {
        return gemCount;
    }

    public void setGemCount(long gemCount) {
        this.gemCount = gemCount;
    }

    public long getCashCount() {
        return cashCount;
    }

    public void setCashCount(long cashCount) {
        this.cashCount = cashCount;
    }
}
