import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double)(a.value) / a.weight;
        double r2 = (double)(b.value) / b.weight;
        if (r1 < r2) return 1;
        else if (r1 > r2) return -1;
        else return 0;
    }
}

// Java program to solve fractional knapsack problem
// using greedy approach
public class Main {
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());

        int curWeight = 0;
        double totalvalue = 0.0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                totalvalue += arr[i].value;
                W -= arr[i].weight;
            } else {
                totalvalue += ((double) arr[i].value / arr[i].weight) * W;
                break;
            }
        }
        return totalvalue;
    }

    public static void main(String args[]) {
        int n = 3, weight = 50;
        Item arr[] = {
            new Item(100, 20),
            new Item(60, 10),
            new Item(120, 30)
        };

        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);
    }
}
//time complexity: O(n log n) for sorting the items based on value/weight ratio
//space complexity: O(1) as we are using constant space for variables