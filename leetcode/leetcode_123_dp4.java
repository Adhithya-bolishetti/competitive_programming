class Solution {
    public int findProfit(int[] prices, int ind, int trans, int[][] dp) {
        if(trans == 4 || ind == prices.length) return 0;

        if(dp[ind][trans] != -1) return dp[ind][trans];

        int profit = 0;
        if(trans % 2 == 0) {
            profit = Math.max(-prices[ind] + findProfit(prices, ind+1, trans+1, dp), findProfit(prices, ind+1, trans, dp));
        }
        else {
            profit = Math.max(prices[ind] + findProfit(prices, ind+1, trans+1, dp), findProfit(prices, ind+1, trans, dp));
        }
        return dp[ind][trans] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        for(int[] row : dp) Arrays.fill(row, -1);

        return findProfit(prices, 0, 0, dp);
    }
}
//Time Complexity: O(N * 4) where N is the number of days
//Space Complexity: O(N * 4) for the dp array