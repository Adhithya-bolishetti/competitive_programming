class Solution {
    public int countCoins(int[] coins, int index, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0) return amount / coins[index];
            else return (int) 1e9; 
        }
        if(dp[index][amount] != -1) return dp[index][amount];

        int notPick = countCoins(coins, index - 1, amount, dp);
        int pick = (int) 1e9;
        if (amount >= coins[index]) {
            pick = 1 + countCoins(coins, index, amount - coins[index], dp);
        }

        return dp[index][amount] = Math.min(pick, notPick);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        int ans = countCoins(coins, coins.length - 1, amount, dp);
        return (ans >= (int) 1e9) ? -1 : ans; 
    }
}
// Time complexity : O(n * amount)
// Space complexity : O(n * amount) + O(n) stack space