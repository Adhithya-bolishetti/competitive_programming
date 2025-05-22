class Solution {
    public void countWays(int n,int[] ways) {
        if(n == 0) ways[0]++;
        if(n >= 1) countWays(n-1,ways);
        if(n >= 2) countWays(n-2,ways);
    }
    public int climbStairs(int n) {
        int[] ways = new int[1];
        countWays(n,ways);
        return ways[0];
    }
}
//Time complexity : O(2^n)
//Space complexity : O(n)