class Solution {
    public int findWays(int[] coins, int index, int amount, int[][] dp) {
        if(index == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int notPick = findWays(coins, index-1, amount, dp);
        int pick = 0;
        if(amount >= coins[index]) {
            pick = findWays(coins, index, amount - coins[index], dp);
        }
        return dp[index][amount] = notPick + pick;
    }
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return findWays(coins, coins.length-1, amount, dp);
    }
}
// Time complexity : O(n * amount)
// Space complexity : O(n * amount) + O(n) stack space