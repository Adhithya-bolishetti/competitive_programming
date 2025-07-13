class Solution {
    public int findProfit(int[] prices, int ind, int buy, int cap) {
        if(cap == 0 || ind == prices.length) return 0;

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[ind] + findProfit(prices, ind+1, 0, cap), findProfit(prices, ind+1, 1, cap));
        }
        else {
            profit = Math.max(prices[ind] + findProfit(prices, ind+1, 1, cap-1), findProfit(prices, ind+1, 0, cap));
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        return findProfit(prices, 0, 1, 2);
    }
}
//Time Complexity: O(N*2*2) = O(N)
//Space Complexity: O(N*2*2) = O(N)