class Solution {
    public int countWays(int n) {
        if(n == 0) return 1;
        int prev2 = 0;
        int prev1 = 1;
        for(int i=1;i<=n;i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public int climbStairs(int n) {
        return countWays(n);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)