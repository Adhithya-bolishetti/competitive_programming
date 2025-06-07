public class Solution {
    public static int knapsack(int[] profit, int[] weight, int index, int w) {
        if (index == 0) {
            return profit[0] * (w / weight[0]); 
        }

        int notPick = knapsack(profit, weight, index - 1, w);
        int pick = Integer.MIN_VALUE;
        if (w >= weight[index]) {
            pick = profit[index] + knapsack(profit, weight, index, w - weight[index]); 
        }
        return Math.max(pick, notPick);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return knapsack(profit, weight, n - 1, w);
    }
}
// Time complexity : exponential
// Space complexity : O(n) stack space