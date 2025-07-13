class Solution {
     public int findProfit(int[] prices, int ind, int trans, int[][] dp, int k) {
        if(trans == k || ind == prices.length) return 0;

        if(dp[ind][trans] != -1) return dp[ind][trans];

        int profit = 0;
        if(trans % 2 == 0) {
            profit = Math.max(-prices[ind] + findProfit(prices, ind+1, trans+1, dp, k), findProfit(prices, ind+1, trans, dp, k));
        }
        else {
            profit = Math.max(prices[ind] + findProfit(prices, ind+1, trans+1, dp, k), findProfit(prices, ind+1, trans, dp, k));
        }
        return dp[ind][trans] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k*2];
        for(int[] row : dp) Arrays.fill(row, -1);

        return findProfit(prices, 0, 0, dp, k*2);
    }
}
// Time Complexity: O(n*k)
// Space Complexity: O(n*k)