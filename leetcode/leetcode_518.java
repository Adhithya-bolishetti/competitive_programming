class Solution {
    public int findWays(int[] coins, int index, int amount) {
        if(index == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        int notPick = findWays(coins, index-1, amount);
        int pick = 0;
        if(amount >= coins[index]) {
            pick = findWays(coins, index, amount - coins[index]);
        }
        return notPick + pick;
    }
    public int change(int amount, int[] coins) {
        return findWays(coins, coins.length-1, amount);
    }
}
// Time complexity : exponential
// Space complexity : O(n) stack space