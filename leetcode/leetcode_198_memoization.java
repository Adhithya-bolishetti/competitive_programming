class Solution {
    public int houseRob(int[] nums,int index,int[] dp) {
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        int pick = nums[index] + houseRob(nums,index-2,dp);
        int notPick = 0 + houseRob(nums,index-1,dp);
        return dp[index] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
       if(nums.length == 1) return nums[0];
       int[] dp = new int[nums.length+1];
       Arrays.fill(dp,-1);
       return houseRob(nums,nums.length-1,dp);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)