class Solution {
    public int partition(int[] nums, int index, int k, int[][] dp) {
        if(k == 0) return 1;
        if(index == 0) return nums[index] == k ? 1 : 0;
        if(dp[index][k] != -1) return dp[index][k];

        int notPick = partition(nums, index-1, k, dp);
        int pick = 0;
        if(k >= nums[index]) pick = partition(nums, index-1, k-nums[index], dp);

        return dp[index][k] = (notPick ==1 || pick == 1) ? 1 : 0;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) sum += val;
        if(sum % 2 != 0) return false;
        int[][] dp = new int[nums.length][(sum/2)+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return partition(nums, nums.length-1, sum/2, dp) == 1 ? true : false ;
    }
}
// Time complexity : O(n*k)
// Space complexity : O(n*k) + O(n)stack