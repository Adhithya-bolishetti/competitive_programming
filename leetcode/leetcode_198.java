class Solution {
    public int houseRob(int[] nums,int index) {
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        int pick = nums[index] + houseRob(nums,index-2);
        int notPick = 0 + houseRob(nums,index-1);
        return Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
       if(nums.length == 1) return nums[0];
       return houseRob(nums,nums.length-1);
    }
}
// Time complexity : O(2^n)
// Space complexity : O(1)