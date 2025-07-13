class Solution {
    public int findProfit(int[] prices, int ind, int buy, int cap, int[][][] dp) {
        if(cap == 0 || ind == prices.length) return 0;

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[ind] + findProfit(prices, ind+1, 0, cap, dp), findProfit(prices, ind+1, 1, cap, dp));
        }
        else {
            profit = Math.max(prices[ind] + findProfit(prices, ind+1, 1, cap-1, dp), findProfit(prices, ind+1, 0, cap, dp));
        }
        return dp[ind][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] layer : dp) {
            for(int[] row : layer) Arrays.fill(row, -1);
        }

        return findProfit(prices, 0, 1, 2, dp);
    }
}
//Time Complexity: O(N * 2 * 3) = O(N)
//Space Complexity: O(N * 2 * 3) = O(N)