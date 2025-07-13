class Solution {
    public int findProfit(int[] prices, int index, int buy, int[][] dp) {
        if(index == prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[index] + findProfit(prices, index+1, 0, dp), findProfit(prices, index+1, 1, dp));
        }
        else {
            profit = profit + Math.max(prices[index] + findProfit(prices, index+1, 1, dp), findProfit(prices, index+1, 0, dp));
        }

        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) Arrays.fill(row, -1);

        return findProfit(prices, 0, 1, dp);
    }
}
//Time Complexity: O(N)
//Space Complexity: O(N) + O(N) for recursion stack