class Solution {
    public int countCoins(int[] coins, int index, int amount) {
        if (index == 0) {
            if (amount % coins[index] == 0) return amount / coins[index];
            else return (int) 1e9; 
        }

        int notPick = countCoins(coins, index - 1, amount);
        int pick = (int) 1e9;
        if (amount >= coins[index]) {
            pick = 1 + countCoins(coins, index, amount - coins[index]);
        }

        return Math.min(pick, notPick);
    }

    public int coinChange(int[] coins, int amount) {
        int ans = countCoins(coins, coins.length - 1, amount);
        return (ans >= (int) 1e9) ? -1 : ans; 
    }
}
// Time complexity : exponential
// Space complexity : O(n) stack space