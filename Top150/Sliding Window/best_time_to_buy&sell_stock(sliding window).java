class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int l = 0;
        int r = 1;

        while(r < n) {
            if(prices[l] < prices[r]) {
                res = Math.max(res, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)