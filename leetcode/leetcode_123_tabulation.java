class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        dp[n][0][0] = dp[n][1][0] = 0;
        
        for(int ind=n-1; ind>=0; ind--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=0; cap<2; cap++) {
                    if(buy == 1) {
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind+1][0][cap], dp[ind+1][1][cap]);
                    }
                    else {
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind+1][1][cap+1], dp[ind+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}
//Time Complexity: O(N*2*2) = O(N)
//Space Complexity: O(N*2*2) = O(N)