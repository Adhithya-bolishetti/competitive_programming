class Solution {
    public int longestIncreasingSubsequence(int[] nums,int  ind, int prev_ind, int[][] dp) {
        if(ind == nums.length) return 0;
        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];
        int notPick = longestIncreasingSubsequence(nums, ind + 1, prev_ind, dp);
        int pick = 0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            pick = 1 + longestIncreasingSubsequence(nums, ind + 1, ind, dp);
        }
        return dp[ind][prev_ind + 1] = Math.max(notPick, pick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        return longestIncreasingSubsequence(nums, 0, -1, dp);
    }
}
// Time complexity : O(n)
// Space complexity : O(n * n) + stack space