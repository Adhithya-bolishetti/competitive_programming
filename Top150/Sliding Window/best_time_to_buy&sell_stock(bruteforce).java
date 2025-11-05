class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(prices[j] > prices[i]) {
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }

        return res;
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(1)