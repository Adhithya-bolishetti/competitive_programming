class Solution {
    public int findProfit(int[] prices, int index, boolean buy) {
        if(index == prices.length) return 0;

        int profit = 0;
        if(buy) {
            profit = Math.max(-prices[index] + findProfit(prices, index+1, false), findProfit(prices, index+1, true));
        }
        else {
            profit = profit + Math.max(prices[index] + findProfit(prices, index+1, true), findProfit(prices, index+1, false));
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
       return findProfit(prices, 0, true);
    }
}
//Time Complexity: O(2^n)
//Space Complexity: O(n) for recursion stack