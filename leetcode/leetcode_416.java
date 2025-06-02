class Solution {
    public boolean partition(int[] nums, int index, int k) {
        if(k == 0) return true;
        if(index == 0) return nums[index] == k;

        boolean notPick = partition(nums, index-1, k);
        boolean pick = false;
        if(k >= nums[index]) pick = partition(nums, index-1, k-nums[index]);

        return notPick || pick ? true : false;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) sum += val;
        if(sum % 2 != 0) return false;
        return partition(nums, nums.length-1, sum/2);
    }
}
// Time complexity : O(2^n))
// Space complexity : O(n) stack space