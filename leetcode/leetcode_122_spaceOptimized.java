class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];

        for(int i=n-1; i>=0; i--) {
            int[] temp = new int[2];
            for(int j=0; j<2; j++) {
                int profit = 0;
                if(j == 1) {
                    profit = Math.max(-prices[i] + dp[0], dp[1]);
                }
                else {
                    profit = Math.max(prices[i] + dp[1], dp[0]);
                }
                temp[j] = profit;
            }
            dp = temp;
        }
        return dp[1];
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)