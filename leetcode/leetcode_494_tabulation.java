class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for (int val : nums) sum += val;

        if (sum - target < 0 || (sum - target) % 2 != 0) return 0;

        int s2 = (sum - target) / 2;
        int[][] dp = new int[n][s2 + 1];

        if (nums[0] == 0) {
            dp[0][0] = 2;  
        } else {
            dp[0][0] = 1; 
            if (nums[0] <= s2) dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= s2; t++) {
                int notPick = dp[i - 1][t];
                int pick = 0;
                if (t >= nums[i]) {
                    pick = dp[i - 1][t - nums[i]];
                }
                dp[i][t] = (notPick + pick);
            }
        }

        return dp[n - 1][s2];
    }
}
// Time complexity : O(n * s2)
// Space complexity : O(n * s2)