class Solution {
    public int houseRob(int[] nums, int index, int[] dp) {
        if(index == 0) return nums[0];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        int pick = nums[index] + houseRob(nums, index - 2, dp);
        int notPick = 0 + houseRob(nums, index - 1, dp);
        return dp[index] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        int a = 0;
        int b = 0;
        for(int i=0;i<nums.length;i++) {
            if(i != 0) arr1[a++] = nums[i];
            if(i != nums.length-1) arr2[b++] = nums[i];
        }
        int[] dp = new int[arr1.length];
        Arrays.fill(dp, -1);
        int[] dp2 = new int[arr2.length];
        Arrays.fill(dp2, -1);
        return Math.max(houseRob(arr1, arr1.length-1, dp),houseRob(arr2, arr2.length-1, dp2));
    }
}
// Time complexity : O(n)
// Space complexity : O(n)