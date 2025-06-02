class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) sum += val;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int k = sum/2;
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (nums[0] <= k) dp[0][nums[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[ind - 1][target];
                boolean pick = false;
                if (target >= nums[ind]) {
                    pick = dp[ind - 1][target - nums[ind]];
                }
                dp[ind][target] = pick || notPick;
            }
        }

        return dp[n - 1][k] ;
    }
}
// Time complexity : O(n*k)
// Space complexity : O(n*K)