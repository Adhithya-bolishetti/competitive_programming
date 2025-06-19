
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {
                int notPick = dp[ind + 1][prev_ind + 1];
                int pick = 0;
                if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev_ind + 1] = Math.max(notPick, pick);
            }
        }

        return dp[0][0];
    }
}
// Time complexity : O(n * n)
// Space complexity : O(n * n)