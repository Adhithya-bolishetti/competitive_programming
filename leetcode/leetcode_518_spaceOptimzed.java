class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        
        for(int i=0; i<= amount; i++) {
            if(i % coins[0] == 0) dp[i] = 1;
        }

        for(int i=1; i<n; i++) {
            int[] temp = new int[amount+1];
            for(int j=0; j<=amount; j++) {
                int notPick = dp[j];
                int pick = 0;
                if(j >= coins[i]) {
                    pick = temp[j - coins[i]];
                }
                temp[j] = pick + notPick;
            }
            dp = temp;
        }
        return dp[amount];
    }
}
// Time complexity : O(n * amount)
// Space complexity : O(amount)