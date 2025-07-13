class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        int[][] dp = new int[2][k+1];

        dp[0][0] = dp[1][0] = 0;
        
        for(int ind=n-1; ind>=0; ind--) {
            int[][] temp = new int[2][k+1];
            for(int buy=0; buy<=1; buy++) {
                for(int cap=0; cap<k; cap++) {
                    if(buy == 1) {
                        temp[buy][cap] = Math.max(-prices[ind] + dp[0][cap], dp[1][cap]);
                    }
                    else {
                        temp[buy][cap] = Math.max(prices[ind] + dp[1][cap+1], dp[0][cap]);
                    }
                }
            }
            dp = temp;
        }
        return dp[1][0];
    }
}
//Time Complexity: O(n*k)
//Space Complexity: O(k) - we can optimize further to O(1) by using only two arrays