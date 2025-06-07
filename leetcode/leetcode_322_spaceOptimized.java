class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        
        for(int i=0; i<=amount; i++) {
            if(i % coins[0] == 0) dp[i] = i / coins[0];
            else dp[i] = (int) 1e9;
        }

        for(int i=1; i<coins.length; i++) {
            int[] temp = new int[amount+1];
            for(int j=0; j<=amount; j++) {
                int notPick = dp[j];
                int pick = (int) 1e9;
                if(j >= coins[i]) {
                    pick = 1 + temp[j - coins[i]];
                }
                temp[j] = Math.min(notPick, pick);
            }
            dp = temp;
        }
        return (dp[amount] >= (int) 1e9) ? -1 : dp[amount]; 
    }
}
// Time complexity : O(n * amount)
// Space complexity : O(amount)