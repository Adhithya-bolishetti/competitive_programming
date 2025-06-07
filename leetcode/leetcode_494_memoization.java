class Solution {
    public static int partition(int[] nums, int index, int k, int[][] dp) {
        if(index == 0) {
			if(k == 0 && nums[0] == 0) return 2;
			if(k == 0 || nums[0] == k) return 1;
			return 0;
		}
        if(dp[index][k] != -1) return dp[index][k];

        int notPick = partition(nums, index-1, k, dp);
        int pick = 0;
        if(k >= nums[index]) pick = partition(nums, index-1, k-nums[index], dp);

        return dp[index][k] = (notPick + pick);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
		for(int val : nums) sum += val;

		if(sum - target < 0 || (sum - target) % 2 == 1) return 0;

		int s2 = (sum - target) / 2;
		int[][] dp = new int[n][s2+1];

		for(int row[]: dp) Arrays.fill(row,-1);

		return partition(nums, n-1, s2, dp);
    }
}
// Time complexity : O(n * s2)
// Space complexity : O(n * s2) + O(n) stack space