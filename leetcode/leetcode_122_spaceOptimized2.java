class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadbuy = 0;
        int aheadnotbuy = 0;

        for(int i=n-1; i>=0; i--) {
            int currbuy = Math.max(-prices[i] + aheadnotbuy, aheadbuy);
            int currnotbuy = Math.max(prices[i] + aheadbuy, aheadnotbuy);

            aheadbuy = currbuy;
            aheadnotbuy = currnotbuy;
        }
        return aheadbuy;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)