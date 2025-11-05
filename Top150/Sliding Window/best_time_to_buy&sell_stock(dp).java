class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = prices[0];

        for(int sell : prices) {
            res = Math.max(res, sell - buy);
            buy = Math.min(buy, sell);
        }

        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)