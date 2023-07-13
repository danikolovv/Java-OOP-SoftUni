package WorkingWithAbstraction.Exercise.P06GreedyTimes;

import java.util.ArrayList;
import java.util.List;

public class Vault {
    private long capacity;
    private List<Item> items;

    public Vault(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void addItem(String name, long quantity) {
        items.add(new Item(name, quantity));
    }
}
