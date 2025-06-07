public class Solution {
    public static int knapsack(int[] profit, int[] weight, int index, int w, int[][] dp) {
        if (index == 0) {
            return profit[0] * (w / weight[0]);
        }
        if (dp[index][w] != -1) return dp[index][w];

        int notPick = knapsack(profit, weight, index - 1, w, dp);
        int pick = Integer.MIN_VALUE;
        if (w >= weight[index]) {
            pick = profit[index] + knapsack(profit, weight, index, w - weight[index], dp);
        }

        return dp[index][w] = Math.max(pick, notPick);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }

        return knapsack(profit, weight, n - 1, w, dp);
    }
}
// Time complexity : O(n * w)
// Space complexity : O(n * w)