class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) sum += val;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int k = sum/2;
         boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        if (nums[0] <= k) {
            dp[nums[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[target];
                boolean pick = false;
                if (target >= nums[ind]) {
                    pick = dp[target - nums[ind]];
                }
                temp[target] = pick || notPick;
            }
            dp = temp;
        }

        return dp[k];
    }
}
// Time complexity : O(n*k)
// Space complexity : O(k)