package WorkingWithAbstraction.Exercise.P06GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] vaultItems = scanner.nextLine().split("\\s+");

        Vault vault = new Vault(capacity);
        Bag bag = new Bag();

        for (int i = 0; i < vaultItems.length; i += 2) {
            String item = vaultItems[i];
            long quantity = Long.parseLong(vaultItems[i + 1]);

            String itemType = ItemAnalyzer.getItemType(item);

            if (itemType.isEmpty() || ItemAnalyzer.exceedsCapacity(capacity, bag, quantity)) {
                continue;
            }

            if (!ItemAnalyzer.canAddToBag(bag, itemType, quantity)) {
                continue;
            }

            bag.updateBag(itemType, item, quantity);
            bag.updateItemCount(itemType, quantity);
        }

        bag.printBagContents();
    }
}
