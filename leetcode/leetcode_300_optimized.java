
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i] ) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max+1;
    }
}
// Time complexity : O(n * n)
// Space complexity : O(n)