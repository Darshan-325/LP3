import java.util.*;

public class FractionalKnapsack {

    static class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static double fractionalKnapsack(int W, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double totalValue = 0.0;
        int remainingWeight = W;

        for (Item item : items) {
            if (item.weight <= remainingWeight) {
                totalValue += item.value;
                remainingWeight -= item.weight;
            } else {
                totalValue += item.value * ((double) remainingWeight / item.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter maximum capacity of knapsack: ");
        int W = sc.nextInt();

        double maxValue = fractionalKnapsack(W, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        sc.close();
    }
}
