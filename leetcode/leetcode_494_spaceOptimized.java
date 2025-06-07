class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int val : nums) sum += val;

        if (sum - target < 0 || (sum - target) % 2 != 0) return 0;

        int s2 = (sum - target) / 2;
        int[] dp = new int[s2 + 1];

        if (nums[0] == 0) {
            dp[0] = 2;  
        } else {
            dp[0] = 1; 
            if (nums[0] <= s2) dp[nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[s2+1];
            for (int t = 0; t <= s2; t++) {
                int notPick = dp[t];
                int pick = 0;
                if (t >= nums[i]) {
                    pick = dp[t - nums[i]];
                }
                temp[t] = (notPick + pick);
            }
            dp = temp;
        }

        return dp[s2];
    }
}
// Time complexity : O(n * s2)
// Space complexity : O(s2)